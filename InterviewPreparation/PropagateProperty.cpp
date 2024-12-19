#include "TCHeader.h"
using namespace std;

int PropagateProperty(char *id)
{
	int status = ITK_ok;
	tag_t Item, *rev_list, relation_t,*sec_obj;
	int count, count1;

	ITK_CALL(ITEM_find_item(id, &Item));
	ITK_CALL(ITEM_list_all_revs(Item, &count, &rev_list));

	cout << "\n\tThe total no. of revision found is:" << count << endl;

	for (int i = 0; i < count; i++)
	{
		char*secPropValue;
		date_t propValue;

		ITK_CALL(AOM_ask_value_date(rev_list[i], "a4RetentionDate", &propValue));
		ITK_CALL(GRM_find_relation_type("IMAN_specification", &relation_t));
		ITK_CALL(GRM_list_secondary_objects_only(rev_list[i], relation_t, &count1, &sec_obj));
		cout << "\n\tThe secondary objects are: " << count1 << endl;

		for (int j = 0; j < count1; j++)
		{

			ITK_CALL(AOM_refresh(sec_obj[i], 1));
			ITK_CALL(AOM_UIF_ask_value(sec_obj[i], "release_status_list", &secPropValue));
			if (tc_strlen(secPropValue) >= 1)
			{
				ITK_CALL(AOM_set_value_date(sec_obj[i], "a4RetentionDate", propValue));
				ITK_CALL(AOM_save_with_extensions(sec_obj[i]));
			}
			ITK_CALL(AOM_refresh(sec_obj[i], 0));


		}

	}


	return status;
}