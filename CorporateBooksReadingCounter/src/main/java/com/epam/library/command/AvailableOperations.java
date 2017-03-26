package com.epam.library.command;

/**
 *
 */
class AvailableOperations {
    private AvailableOperations() {
    }

    static final String MENU_COMMAND = "menu";
    static final String VIEW_COMMAND = "view";
    static final String REPORT_COMMAND = "report";
    static final String RENAME_COMMAND = "rename";
    static final String EXIT_COMMAND = "exit";
    static final String BOOKS_PARAM = "books";
    static final String EMPLOYEES_LONG_PARAM = "employees";
    static final String EMPLOYEES_SHORT_PARAM = "emps";
    static final String LESS_OR_EQ_THAN_2_PARAM = "<=2";
    static final String MORE_THAN_1_PARAM = ">1";
    static final String MASK_PARAM = "m";
    static final String TITLE_PARAM = "t";
    static final String INVALID_COMMAND_MESSAGE = "Failed: invalid command";
    static final String INVALID_PARAMETER_LIST_MESSAGE = "Failed: invalid parameter list";
    static final String INVALID_TITLE_MESSAGE = "Failed: no book with such title was found in database";
    static final String EXIT_MESSAGE = "Application was terminated";
}
