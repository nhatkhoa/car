package com.kms.training.codequaility.cleancode.builders;

public enum ChartErrorCode {
	@Message("There are some error still were not handled!") NONE,

	@Message("The path to input file is empty.") FILE_INPUT_NULL,

	@Message("Can not read input file database.") READ_FILE_ERROR,

	@Message("There are no car in input file or have error on reading file.") DATA_EMPTY
}
