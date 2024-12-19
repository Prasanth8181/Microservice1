#include "TCHeader.h"
FILE* logFile = NULL;

int ReleasedRevision(char* id)
{
	const char* outputFile = NULL;
	outputFile = ITK_ask_cli_argument("-log=");
	fopen_s(&logFile, outputFile, "w");
	int status = ITK_ok;
	tag_t item;

	status = ITEM_find_item(id, &item);
	if (status == ITK_ok)
	{
		cout << "\n\t Item Found!!" << endl;
		TC_write_syslog("Item Found!!");
	}
	error(status);
	tag_t* rev_list;
	int count;
	char *value,*ItemID, *RevisionID, *ObjName, *ItemDesc, *CreationDate;
	

	status = ITEM_list_all_revs(item, &count, &rev_list);
	cout << "\n\tThe total Revision is:" << count << endl;
	fprintf(logFile, "The total Revision is : %d\n", count);
	cout << left << setw(10) << "Item ID" << "|"
		<< setw(15) << "Revision ID" << "|"
		<< setw(30) << "Item Name" << "|" << setw(30) << "Item Description" << "|" <<setw(15) << "Item Creation Date" << endl;
	cout << string(120, '-') <<endl;
	fprintf(logFile, "%-10s|%-15s|%-30s|%-30s|%-15s|\n", "Item ID", "Revision ID", "Item Name", "Item Description", "Item Creation Date");
	fprintf(logFile, "%s\n", std::string(100, '-').c_str());

	for (int i = 0; i < count; i++)
	{
		
		status = AOM_UIF_ask_value(rev_list[i], "release_status_list", &value);

		if (tc_strlen(value)>=1)
		{
			status = AOM_UIF_ask_value(rev_list[i], "item_id", &ItemID);
			//cout << "\n\tItem ID:" << ItemID << endl;
			//fprintf(logFile, "\n\tItem ID: %s", ItemID);
			status = AOM_UIF_ask_value(rev_list[i], "item_revision_id", &RevisionID);
			//cout << "\n\tRevision ID:" << RevisionID << endl;
			//fprintf(logFile, "\n\tRevision ID: %s", RevisionID);
			status = AOM_UIF_ask_value(rev_list[i], "object_name", &ObjName);
			//cout << "\n\tItem Name:" << ObjName << endl;
			//fprintf(logFile, "\n\tItem Name: %s", ObjName);
			status = AOM_UIF_ask_value(rev_list[i], "object_desc", &ItemDesc);
			//cout << "\n\tItem Description:" << ItemDesc << endl;
			//fprintf(logFile, "\n\tItem Description: %s", ItemDesc);
			status = AOM_UIF_ask_value(rev_list[i], "creation_date", &CreationDate);
			//cout << "\n\tItem Creation Date:" << CreationDate << endl;
			//fprintf(logFile, "\n\tItem Creation Date: %s", CreationDate);
			
			cout << "\n";
			cout << left << setw(10) << ItemID<< "|" << setw(15) << RevisionID<< "|" << setw(30) << ObjName<< "|" << setw(30) << ItemDesc<< "|" << setw(15) << CreationDate<<endl;
			fprintf(logFile, "%-10s|%-15s|%-30s|%-30s|%-15s|\n", ItemID,RevisionID , ObjName, ItemDesc, CreationDate);


		}

	}
	fclose(logFile);
	
	return status;
}