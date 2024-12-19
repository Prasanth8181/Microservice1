#include"TCHeader.h"
FILE* logFile = NULL;


void SubChild(tag_t child);
int ItemBOMLine(char *id)
{
	const char* outputFile = NULL;
	outputFile = ITK_ask_cli_argument("-log=");
	fopen_s(&logFile, outputFile, "w");

	int status = ITK_ok;
	tag_t item, rev_t, window, top_BOM_Line,*child;
	int count;
	char* value, * value1;

	ITK_CALL(ITEM_find_item(id, &item));
	ITK_CALL(ITEM_find_revision(item,"A",&rev_t));
	ITK_CALL(BOM_create_window(&window));
	ITK_CALL(BOM_set_window_top_line(window, item, rev_t, NULLTAG, &top_BOM_Line));
	ITK_CALL(BOM_line_ask_all_child_lines(top_BOM_Line, &count, &child));
	if (status == ITK_ok)
	{
		cout << "Child level found" << endl;
		fprintf(logFile,"The child count is : ", count);
	}
	for (int i = 0; i < count; i++)
	{
		status = AOM_UIF_ask_value(child[i], "bl_indented_title", &value);
		cout << "Child = " << value;
		fprintf(logFile,"Child = %s\n", value);
		SubChild(child[i]);

	}
	fclose(logFile);




	return status;
}

void SubChild(tag_t child)
{
	int status = ITK_ok;
	char* msg = NULL;
	tag_t* subchild1;
	int count1;
	char* value1;

	status = BOM_line_ask_all_child_lines(child, &count1, &subchild1);
	if (status == ITK_ok)
	{
		cout << "The subchild count is :" << count1 << endl;
		fprintf(logFile, "The subchild count is : %d\n", count1);
	}
	for (int j = 0; j < count1; j++)
	{
		status = AOM_UIF_ask_value(subchild1[j], "bl_indented_title", &value1);
		cout << "subChild = " << value1;
		fprintf(logFile,"Child = %s\n", value1);
		SubChild(subchild1[j]);

	}


}
