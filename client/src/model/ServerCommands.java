package model;

import java.io.Serializable;

public enum ServerCommands implements Serializable {

	GETCUSTOMERS, GETSALESREPORT, REGISTERCUSTOMER, VERIFYCUSTOMER, GETALLINVENTORY, REGISTERSTAFF, VERIFYSTAFF,
	NEWINVOICE, SUBMITINVOICE, UPDATEINVENTORY, ADDINVENTORY, DELETEINVENTORY, GETALLSTAFF;

}