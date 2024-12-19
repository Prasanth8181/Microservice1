#include"TCLogin.h"


int CreateItem()
{
	int status = ITK_ok;
	char* msg = NULL;
	tag_t Item_t, create_input, Item;
	char* strItemId;

	status = TCTYPE_ask_type("A4ClientItem", &Item_t);

	status = TCTYPE_construct_create_input(Item_t, &create_input);

	status = AOM_set_value_string(create_input, "object_name", "ObjectName");

	status = TCTYPE_create_object(create_input, &Item);
	if (status == ITK_ok)
	{
		cout << "\n\tItem Created successfully!!!" << endl;
	}
	error(status);

	status = AOM_save_with_extensions(Item);

	//status = AOM_refresh(Item, false);

	status = AOM_ask_value_string(Item, "item_id", &strItemId);
	cout << "\n\tThe Item ID is :" << strItemId <<endl;
	MEM_free(strItemId);
	tag_t rev_t;
	status = ITEM_find_revision(Item, "A", &rev_t);

	//Create dataset
	tag_t datasettype, newDataset;

	status = AE_find_datasettype2("Text", &datasettype);
	status = AE_create_dataset_with_id(datasettype, "Test", "Test1", "", "", &newDataset);
	if (status == ITK_ok)
	{
		cout << "\n\tDataset Created successfully!!!" << endl;
	}
	error(status);
	status = AE_save_myself(newDataset);
	

	//Create Relation
	tag_t relation_type, relation;

	status = GRM_find_relation_type("IMAN_specification", &relation_type);
	status = GRM_create_relation(rev_t, newDataset, relation_type, NULLTAG, &relation);
	if (status == ITK_ok)
	{
		cout << "\n\tRelation created successfully!!!" << endl;
	}
	error(status);
	status = GRM_save_relation(relation);
	cout << "\n\tRelation saved!!!" << endl;

	//Import Named Reference
	status = AOM_refresh(newDataset, 1);
	status = AE_import_named_ref(newDataset, "Text", "C:\\Users\\13479\\Downloads\\test1.txt", NULL, SS_TEXT);
	if (status == ITK_ok)
	{
		cout << "\n\tImported Named reference successfully!!!" << endl;
	}
	error(status);
	status = AOM_save_with_extensions(newDataset);
	status = AOM_refresh(newDataset, 0);
	
	//Attach Form to Item

	tag_t new_form, relation_t, rel;

	status = FORM_create2("Technical Form", "", "A4TechnicalForm", &new_form);
	if (status == ITK_ok)
	{
		cout << "\n\tForm Created successfully!!!" << endl;
	}
	error(status);

	status = AOM_save_with_extensions(new_form);

	status = GRM_find_relation_type("IMAN_reference", &relation_t);

	status = GRM_create_relation(rev_t, new_form, relation_t, NULLTAG, &rel);
	if (status == ITK_ok)
	{
		cout << "\n\tForm attached to Item successfully!!!" << endl;
	}
	error(status);

	status = GRM_save_relation(rel);
	//status = AOM_refresh(relation, FALSE);
	cout << "\n\tRelation saved!!!" << endl;

	return status;
}