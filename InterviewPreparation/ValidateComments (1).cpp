/*Checking whether PDF is attached to the ItemRevision or not */
#include"Header.h"
#define DLLAPI _declspec(dllexport)
#define PLM_error (EMH_USER_error_base+9)
using namespace std;

extern "C"
{
	extern DLLAPI int DLLProject_register_callbacks();
	extern DLLAPI int Handler_execute_callback(int *decision, va_list args);
	extern DLLAPI int Validate_comments(EPM_rule_message_t msg);
	extern DLLAPI int DLLProject_register_callbacks()
	{
		    outPut.open(filePath);
			ifail = CUSTOM_register_exit("DLLProject", "USER_init_module", (CUSTOM_EXIT_ftn_t)Handler_execute_callback);
			printInFile(" DLLProject Dll registering done :");
			ifailcheck(ifail);
			return ifail;	
	}
	extern DLLAPI int Handler_execute_callback(int *decision, va_list args)
	{
		*decision = ALL_CUSTOMIZATIONS;
		printInFile("Login successfull :");
		ifail = EPM_register_rule_handler("Validate_comments", "Validate_comments", (EPM_rule_handler_t)Validate_comments);
		ifailcheck(ifail);
		printInFile("EPM_register_rule_handler :   Validate_comments");
		return ifail;
	}
	extern DLLAPI int Validate_comments(EPM_rule_message_t msg)
	{
		EPM_decision_t decision = EPM_go;
		tag_t current_task = NULLTAG;
		current_task = msg.task;
		char* object_name = NULL;
		char* comments;
		ifailcheck(AOM_ask_value_string(current_task, "object_name", &object_name));
		printInFile("object_name :",object_name);
		ifailcheck(AOM_ask_value_string(current_task, "comments", &comments));
		printInFile("Task state value :", comments);
		if (strcmp(comments,"")==0|| comments==NULL)
		{
			decision = EPM_nogo;
		}
		return decision;
	}
}