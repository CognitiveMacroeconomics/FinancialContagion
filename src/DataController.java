import java.util.ArrayList;


public class DataController {
	
	String [] bankName;
	
	public static String [] getBanksNameShortAndOutsideEntity (){
		
		//2004Q1 Full Network With ICE
		String [] values = {
		//these names are at gross notional
				"AMSOUTH",
				"BANK LEUMI",
				"BANK OF AMERICA",
				"BONY",
				"TOKYO-MITSUBISHI",
				"BANK ONE",
				"CITIBANK",
				"CITIZENS CT",
				"CITIZENS MA",
				"CITIZENS PA",
				"CITIZENS",
				"DEUTSCHE",
				"ENTERPRISE",
				"FIRST AMERICAN",
				"FLEET NATIONAL",
				"HARRIS",
				"HSBC",
				"JPMORGAN",
				"JUNIPER",
				"KEYBANK",
				"MELLON",
				"MERRILL LYNCH",
				"MIDWEST BANK",
				"MORGAN STANLEY",
				"NATIONAL CITY",
				"NORTHERN TRUST",
				"PALMETTO",
				"PARK AVENUE",
				"PNC BANK",
				"PROVIDENT",
				"SUNTRUST",
				"U.S. BANK",
				"WACHOVIA",
				"WELLS FARGO",
				"WELLS FARGO HSBC",
		
		
		//these names are at gross fair value
//		"BANK LEUMI",
//		"BANK OF AMERICA",
//		"BONY",
//		"BANK ONE",
//		"DEUTSCHE",
//		"CITIBANK",
//		"CITIZENS CT",
//		"CITIZENS MA",
//		"CITIZENS PA",
//		"CITIZENS BANK",
//		"ENTERPRISE NBPB",
//		"WACHOVIA",
//		"FLEET NATIONAL",
//		"HSBC",
//		"JPMORGAN",
//		"KEYBANK",
//		"MELLON",
//		"MERRILL",
//		"MIDWEST BTC",
//		"NORTHERN TRUST",
//		"PNC",
//		"SUNTRUST",
//		"U.S. BANK",
//		"WELLS FARGO",
		
		
				"Outside Entity"
				};
		
		
//		//2006Q4 Full Network Without ICE
//		String [] values = {
//				//these names are at gross notional
//				"BANK LEUMI",
//				"BANK OF AMERICA",
//				"BONY",
//				"TOKYO-MITSUBISHI",
//				"BRANCH BANKING",
//				"CALIFORNIA B&T",
//				"CHARTER ONE",
//				"CITIBANK",
//				"CITIZENS HA",
//				"CITIZENS MA",
//				"CITIZENS PA",
//				"COMERICA",
//				"COMMERCE BANK",
//				"COMMERCEBANK",
//				"DEUTSCHE",
//				"HSBC",
//				"JPMORGAN",
//				"KEYBANK",
//				"LASALLE BANK",
//				"MELLON BANK",
//				"MERCANTILE-SAFE",
//				"MERRILL LYNCH",
//				"MORGAN STANLEY",
//				"NATIONAL CITY",
//				"NORTHERN TRUST",
//				"PNC BANK",
//				"REGIONS BANK",
//				"STATE STREET",
//				"SUNTRUST",
//				"U.S. BANK",
//				"WACHOVIA",
//				"WELLS FARGO",


				//these names are at Gross Fair Value
//				"BANK OF AMERICA",
//				"BONY",
//				"DEUTSCHE BANK",
//				"BRANCH BANKING AND TRUST COMPANY",
//				"CALIFORNIA BANK & TRUST",
//				"CHARTER ONE BANK",
//				"CITIBANK",
//				"CITIZENS BANK HA",
//				"CITIZENS BANK MA",
//				"CITIZENS BANK PA",
//				"COMERICA",
//				"COMMERCE BANK",
//				"COMMERCEBANK",
//				"WACHOVIA",
//				"HSBC",
//				"JPMORGAN",
//				"KEYBANK",
//				"MERCANTILE-SAFE",
//				"MERRILL",
//				"MORGAN STANLEY",
//				"NATIONAL CITY",
//				"NORTHERN TRUST",
//				"PNC",
//				"REGIONS",
//				"SUNTRUST",
//				"U.S. BANK",
//				"WELLS FARGO",
			
				
				
//				"Outside Entity"
//				};
		
//		//2007Q4 Full Network With ICE
//		String [] values = {
		//these names are at gross notional
//				"BANK LEUMI",
//				"BANK OF AMERICA",
//				"BONY",
//				"TOKYO-MITSUBISHI",
//				"BRANCH BANKING",
//				"CALIFORNIA B&T",
//				"CITIBANK",
//				"CITIZENS PA",
//				"COMERICA",
//				"COMMERCEBANK",
//				"DEUTSCHE",
//				"GOLDMAN",
//				"HORICON",
//				"HSBC",
//				"JOHNSON",
//				"JPMORGAN",
//				"KEYBANK",
//				"MERRILL LYNCH",
//				"MORGAN STANLEY",
//				"NATIONAL CITY",
//				"NORTHERN TRUST",
//				"PNC BANK",
//				"RBS CITIZENS",
//				"REGIONS BANK",
//				"SOUTHWEST TX",
//				"STANDARD FEDERAL",
//				"STATE STREET",
//				"SUNTRUST",
//				"U.S. BANK",
//				"WACHOVIA",
//				"WELLS FARGO",
		//these names are at gross fair value
		
//		"BANK LEUMI",
//		"BANK OF AMERICA",
//		"BONY",
//		"TOKYO-MITSUBISHI",
//		"DEUTSCHE",
//		"BRANCH BANKING",
//		"CALIFORNIA BT",
//		"CITIBANK",
//		"CITIZENS PA",
//		"COMERICA",
//		"COMMERCE BANK",
//		"WACHOVIA BANK",
//		"GOLDMAN",
//		"HORICON",
//		"HSBC",
//		"JOHNSON",
//		"JPMORGAN",
//		"KEYBANK",
//		"LASALLE BANK",
//		"MERRILL",
//		"MORGAN STANLEY",
//		"NATIONAL CITY",
//		"NORTHERN TRUST",
//		"PNC",
//		"RBS CITIZENS",
//		"REGIONS",
//		"STANDARD FEDERAL",
//		"STATE STREET",
//		"SUNTRUST",
//		"U.S. BANK",
//		"WELLS FARGO",
//
//				"Outside Entity"
//				};
		
		//2008Q4 Full Network With ICE
//		String [] values = {
//		"ASSOCIATED BANK, NATIONAL ASSOCIATION",
//		"BANK LEUMI USA",
//		"BANK OF AMERICA, NATIONAL ASSOCIATION",
//		"BANK OF NEW YORK, THEv
//		"BANK OF TOKYO-MITSUBISHI TRUST COMPANY",
//		"BANKNORTH, NATIONAL ASSOCIATION",
//		"CALIFORNIA BANK & TRUST",
//		"CITIBANK, N.A.",
//		"CITIZENS BANK OF PENNSYLVANIA",
//		"COMERICA BANK",
//		"COMMERCEBANK, NATIONAL ASSOCIATION",
//		"Deutsche Bank Trust Company Americas",
//		"GOLDMAN SACHS BANK USA",
//		"HORICON STATE BANK",
//		"HSBC BANK USA",
//		"ICE TRUST U.S. LLC",
//		"JPMORGAN CHASE BANK",
//		"KEYBANK NATIONAL ASSOCIATION",
//		"MORGAN STANLEY BANK",
//		"NATIONAL CITY BANK",
//		"NORTHERN TRUST COMPANY, THE",
//		"PARK AVENUE BANK, NATIONAL ASSOCIATION, THE",
//		"PNC BANK, NATIONAL ASSOCIATION",
//		"RBS CITIZENS, NATIONAL ASSOCIATION",
//		"SIGNATURE BANK",
//		"STATE STREET BANK AND TRUST COMPANY",
//		"SOUTHWEST BANK OF TEXAS, N.A.",
//		"SUNTRUST BANK",
//		"U.S. BANK NATIONAL ASSOCIATION",
//		"WACHOVIA BANK, NATIONAL ASSOCIATION",
//		"WELLS FARGO BANK, NATIONAL ASSOCIATION",
//		"Outside Entity"
//				};
		
		
		return values;
	}
	
	public static String [] getBanksNameShortAndInsuranceCompanies ()
	{

		
		//2004Q1 Full Network With ICE
		String [] values = {
				"AMSOUTH",
				"BANK LEUMI",
				"BANK OF AMERICA",
				"BONY",
				"TOKYO-MITSUBISHI",
				"BANK ONE",
				"CITIBANK",
				"CITIZENS CT",
				"CITIZENS MA",
				"CITIZENS PA",
				"CITIZENS",
				"DEUTSCHE",
				"ENTERPRISE",
				"FIRST AMERICAN",
				"FLEET NATIONAL",
				"HARRIS",
				"HSBC",
				"JPMORGAN",
				"JUNIPER",
				"KEYBANK",
				"MELLON",
				"MERRILL LYNCH",
				"MIDWEST BANK",
				"MORGAN STANLEY",
				"NATIONAL CITY",
				"NORTHERN TRUST",
				"PALMETTO",
				"PARK AVENUE",
				"PNC BANK",
				"PROVIDENT",
				"SUNTRUST",
				"U.S. BANK",
				"WACHOVIA",
				"WELLS FARGO",
				"WELLS FARGO HSBC",
		
		//Short names Gross Fair Value
		
//				"BANK LEUMI",
//				"BANK OF AMERICA",
//				"BONY",
//				"BANK ONE",
//				"DEUTSCHE",
//				"CITIBANK",
//				"CITIZENS CT",
//				"CITIZENS MA",
//				"CITIZENS PA",
//				"CITIZENS BANK",
//				"ENTERPRISE NBPB",
//				"WACHOVIA",
//				"FLEET NATIONAL",
//				"HSBC",
//				"JPMORGAN",
//				"KEYBANK",
//				"MELLON",
//				"MERRILL",
//				"MIDWEST BTC",
//				"NORTHERN TRUST",
//				"PNC",
//				"SUNTRUST",
//				"U.S. BANK",
//				"WELLS FARGO",
//
//		
//		
				"Insurance Companies",
				"Non US Banks"
				};
		
		
		
		//2006Q4 Full Network With ICE
//		String [] values = {
//				//Full names for Gross Notional Value
//				"BANK LEUMI",
//				"BANK OF AMERICA",
//				"BONY",
//				"TOKYO-MITSUBISHI",
//				"BRANCH BANKING",
//				"CALIFORNIA B&T",
//				"CHARTER ONE",
//				"CITIBANK",
//				"CITIZENS HA",
//				"CITIZENS MA",
//				"CITIZENS PA",
//				"COMERICA",
//				"COMMERCE BANK",
//				"COMMERCEBANK",
//				"DEUTSCHE",
//				"HSBC",
//				"JPMORGAN",
//				"KEYBANK",
//				"LASALLE BANK",
//				"MELLON BANK",
//				"MERCANTILE-SAFE",
//				"MERRILL LYNCH",
//				"MORGAN STANLEY",
//				"NATIONAL CITY",
//				"NORTHERN TRUST",
//				"PNC BANK",
//				"REGIONS BANK",
//				"STATE STREET",
//				"SUNTRUST",
//				"U.S. BANK",
//				"WACHOVIA",
//				"WELLS FARGO",
				//short names for Gross Fair Values
				
//				"BANK OF AMERICA",
//				"BONY",
//				"DEUTSCHE BANK",
//				"BRANCH BANKING",
//				"CALIFORNIA BT",
//				"CHARTER ONE BANK",
//				"CITIBANK",
//				"CITIZENS BANK HA",
//				"CITIZENS BANK MA",
//				"CITIZENS BANK PA",
//				"COMERICA",
//				"COMMERCE BANK",
//				"COMMERCEBANK",
//				"WACHOVIA",
//				"HSBC",
//				"JPMORGAN",
//				"KEYBANK",
//				"MERCANTILE-SAFE",
//				"MERRILL",
//				"MORGAN STANLEY",
//				"NATIONAL CITY",
//				"NORTHERN TRUST",
//				"PNC",
//				"REGIONS",
//				"SUNTRUST",
//				"U.S. BANK",
//				"WELLS FARGO",
				
				
				
//				"Insurance Companies",
//				"Non US Banks"
//				};
		
//		//2007Q4 Full Network With ICE
//		String [] values = {
		//Full names for Gross Notional Values
//				"BANK LEUMI",
//				"BANK OF AMERICA",
//				"BONY",
//				"TOKYO-MITSUBISHI",
//				"BRANCH BANKING",
//				"CALIFORNIA B&T",
//				"CITIBANK",
//				"CITIZENS PA",
//				"COMERICA",
//				"COMMERCEBANK",
//				"DEUTSCHE",
//				"GOLDMAN",
//				"HORICON",
//				"HSBC",
//				"JOHNSON",
//				"JPMORGAN",
//				"KEYBANK",
//				"MERRILL LYNCH",
//				"MORGAN STANLEY",
//				"NATIONAL CITY",
//				"NORTHERN TRUST",
//				"PNC BANK",
//				"RBS CITIZENS",
//				"REGIONS BANK",
//				"SOUTHWEST TX",
//				"STANDARD FEDERAL",
//				"STATE STREET",
//				"SUNTRUST",
//				"U.S. BANK",
//				"WACHOVIA",
//				"WELLS FARGO",
		
		
		//Short names for Gross Fair Value
//		"BANK LEUMI",
//		"BANK OF AMERICA",
//		"BONY",
//		"TOKYO-MITSUBISHI",
//		"DEUTSCHE",
//		"BRANCH BANKING",
//		"CALIFORNIA BT",
//		"CITIBANK",
//		"CITIZENS PA",
//		"COMERICA",
//		"COMMERCE BANK",
//		"WACHOVIA BANK",
//		"GOLDMAN",
//		"HORICON",
//		"HSBC",
//		"JOHNSON",
//		"JPMORGAN",
//		"KEYBANK",
//		"LASALLE BANK",
//		"MERRILL",
//		"MORGAN STANLEY",
//		"NATIONAL CITY",
//		"NORTHERN TRUST",
//		"PNC",
//		"RBS CITIZENS",
//		"REGIONS",
//		"STANDARD FEDERAL",
//		"STATE STREET",
//		"SUNTRUST",
//		"U.S. BANK",
//		"WELLS FARGO",
//
//		
//				"Insurance Companies",
//				"Non US Banks"
//				};
//		
		//2008Q4 Full Network With ICE
//		String [] values = {
//				"ASSOCIATED BANK, NATIONAL ASSOCIATION",
//				"BANK LEUMI USA",
//				"BANK OF AMERICA, NATIONAL ASSOCIATION",
//				"BANK OF NEW YORK, THEv
//				"BANK OF TOKYO-MITSUBISHI TRUST COMPANY",
//				"BANKNORTH, NATIONAL ASSOCIATION",
//				"CALIFORNIA BANK & TRUST",
//				"CITIBANK, N.A.",
//				"CITIZENS BANK OF PENNSYLVANIA",
//				"COMERICA BANK",
//				"COMMERCEBANK, NATIONAL ASSOCIATION",
//				"Deutsche Bank Trust Company Americas",
//				"GOLDMAN SACHS BANK USA",
//				"HORICON STATE BANK",
//				"HSBC BANK USA",
//				"ICE TRUST U.S. LLC",
//				"JPMORGAN CHASE BANK",
//				"KEYBANK NATIONAL ASSOCIATION",
//				"MORGAN STANLEY BANK",
//				"NATIONAL CITY BANK",
//				"NORTHERN TRUST COMPANY, THE",
//				"PARK AVENUE BANK, NATIONAL ASSOCIATION, THE",
//				"PNC BANK, NATIONAL ASSOCIATION",
//				"RBS CITIZENS, NATIONAL ASSOCIATION",
//				"SIGNATURE BANK",
//				"STATE STREET BANK AND TRUST COMPANY",
//				"SOUTHWEST BANK OF TEXAS, N.A.",
//				"SUNTRUST BANK",
//				"U.S. BANK NATIONAL ASSOCIATION",
//				"WACHOVIA BANK, NATIONAL ASSOCIATION",
//				"WELLS FARGO BANK, NATIONAL ASSOCIATION",
//				"Insurance Companies",
//				"Non US Banks"
//				};
		

		return values;
	}
	
	public static String [] getBanksNameShort ()
	{

		//2004Q1 Full Network With ICE
		String [] values = {
				"AMSOUTH",
				"BANK LEUMI",
				"BANK OF AMERICA",
				"BONY",
				"TOKYO-MITSUBISHI",
				"BANK ONE",
				"CITIBANK",
				"CITIZENS CT",
				"CITIZENS MA",
				"CITIZENS PA",
				"CITIZENS",
				"DEUTSCHE",
				"ENTERPRISE",
				"FIRST AMERICAN",
				"FLEET NATIONAL",
				"HARRIS",
				"HSBC",
				"JPMORGAN",
				"JUNIPER",
				"KEYBANK",
				"MELLON",
				"MERRILL LYNCH",
				"MIDWEST BANK",
				"MORGAN STANLEY",
				"NATIONAL CITY",
				"NORTHERN TRUST",
				"PALMETTO",
				"PARK AVENUE",
				"PNC BANK",
				"PROVIDENT",
				"SUNTRUST",
				"U.S. BANK",
				"WACHOVIA",
				"WELLS FARGO",
				"WELLS FARGO HSBC"
		
		
		//Gross Fair Value Names
//				"BANK LEUMI",
//				"BANK OF AMERICA",
//				"BONY",
//				"BANK ONE",
//				"DEUTSCHE",
//				"CITIBANK",
//				"CITIZENS CT",
//				"CITIZENS MA",
//				"CITIZENS PA",
//				"CITIZENS BANK",
//				"ENTERPRISE NBPB",
//				"WACHOVIA",
//				"FLEET NATIONAL",
//				"HSBC",
//				"JPMORGAN",
//				"KEYBANK",
//				"MELLON",
//				"MERRILL",
//				"MIDWEST BTC",
//				"NORTHERN TRUST",
//				"PNC",
//				"SUNTRUST",
//				"U.S. BANK",
//				"WELLS FARGO",
//
//		
//		
				};
		
		
		//2006Q4 Full Network Without ICE
//		String [] values = {
//				"BANK LEUMI",
//				"BANK OF AMERICA",
//				"BONY",
//				"TOKYO-MITSUBISHI",
//				"BRANCH BANKING",
//				"CALIFORNIA B&T",
//				"CHARTER ONE",
//				"CITIBANK",
//				"CITIZENS HA",
//				"CITIZENS MA",
//				"CITIZENS PA",
//				"COMERICA",
//				"COMMERCE BANK",
//				"COMMERCEBANK",
//				"DEUTSCHE",
//				"HSBC",
//				"JPMORGAN",
//				"KEYBANK",
//				"LASALLE BANK",
//				"MELLON BANK",
//				"MERCANTILE-SAFE",
//				"MERRILL LYNCH",
//				"MORGAN STANLEY",
//				"NATIONAL CITY",
//				"NORTHERN TRUST",
//				"PNC BANK",
//				"REGIONS BANK",
//				"STATE STREET",
//				"SUNTRUST",
//				"U.S. BANK",
//				"WACHOVIA",
//				"WELLS FARGO"
				
				
				//Gross Fair Value Names
//				"BANK OF AMERICA",
//				"BONY",
//				"DEUTSCHE BANK",
//				"BRANCH BANKING",
//				"CALIFORNIA BT",
//				"CHARTER ONE BANK",
//				"CITIBANK",
//				"CITIZENS BANK HA",
//				"CITIZENS BANK MA",
//				"CITIZENS BANK PA",
//				"COMERICA",
//				"COMMERCE BANK",
//				"COMMERCEBANK",
//				"WACHOVIA",
//				"HSBC",
//				"JPMORGAN",
//				"KEYBANK",
//				"MERCANTILE-SAFE",
//				"MERRILL",
//				"MORGAN STANLEY",
//				"NATIONAL CITY",
//				"NORTHERN TRUST",
//				"PNC",
//				"REGIONS",
//				"SUNTRUST",
//				"U.S. BANK",
//				"WELLS FARGO",

				
				

//				};
		
//		//2007Q4 Full Network With ICE
//		String [] values = {
//				"BANK LEUMI",
//				"BANK OF AMERICA",
//				"BONY",
//				"TOKYO-MITSUBISHI",
//				"BRANCH BANKING",
//				"CALIFORNIA B&T",
//				"CITIBANK",
//				"CITIZENS PA",
//				"COMERICA",
//				"COMMERCEBANK",
//				"DEUTSCHE",
//				"GOLDMAN",
//				"HORICON",
//				"HSBC",
//				"JOHNSON",
//				"JPMORGAN",
//				"KEYBANK",
//				"MERRILL LYNCH",
//				"MORGAN STANLEY",
//				"NATIONAL CITY",
//				"NORTHERN TRUST",
//				"PNC BANK",
//				"RBS CITIZENS",
//				"REGIONS BANK",
//				"SOUTHWEST TX",
//				"STANDARD FEDERAL",
//				"STATE STREET",
//				"SUNTRUST",
//				"U.S. BANK",
//				"WACHOVIA",
//				"WELLS FARGO",
		
		
		//Gross Fair Value Names
//		"BANK LEUMI",
//		"BANK OF AMERICA",
//		"BONY",
//		"TOKYO-MITSUBISHI",
//		"DEUTSCHE",
//		"BRANCH BANKING",
//		"CALIFORNIA BT",
//		"CITIBANK",
//		"CITIZENS PA",
//		"COMERICA",
//		"COMMERCE BANK",
//		"WACHOVIA BANK",
//		"GOLDMAN",
//		"HORICON",
//		"HSBC",
//		"JOHNSON",
//		"JPMORGAN",
//		"KEYBANK",
//		"LASALLE BANK",
//		"MERRILL",
//		"MORGAN STANLEY",
//		"NATIONAL CITY",
//		"NORTHERN TRUST",
//		"PNC",
//		"RBS CITIZENS",
//		"REGIONS",
//		"STANDARD FEDERAL",
//		"STATE STREET",
//		"SUNTRUST",
//		"U.S. BANK",
//		"WELLS FARGO",
//				};
//		
		//2008Q4 Full Network With ICE
//		String [] values = {
//				"ASSOCIATED BANK, NATIONAL ASSOCIATION",
//				"BANK LEUMI USA",
//				"BANK OF AMERICA, NATIONAL ASSOCIATION",
//				"BANK OF NEW YORK, THEv
//				"BANK OF TOKYO-MITSUBISHI TRUST COMPANY",
//				"BANKNORTH, NATIONAL ASSOCIATION",
//				"CALIFORNIA BANK & TRUST",
//				"CITIBANK, N.A.",
//				"CITIZENS BANK OF PENNSYLVANIA",
//				"COMERICA BANK",
//				"COMMERCEBANK, NATIONAL ASSOCIATION",
//				"Deutsche Bank Trust Company Americas",
//				"GOLDMAN SACHS BANK USA",
//				"HORICON STATE BANK",
//				"HSBC BANK USA",
//				"ICE TRUST U.S. LLC",
//				"JPMORGAN CHASE BANK",
//				"KEYBANK NATIONAL ASSOCIATION",
//				"MORGAN STANLEY BANK",
//				"NATIONAL CITY BANK",
//				"NORTHERN TRUST COMPANY, THE",
//				"PARK AVENUE BANK, NATIONAL ASSOCIATION, THE",
//				"PNC BANK, NATIONAL ASSOCIATION",
//				"RBS CITIZENS, NATIONAL ASSOCIATION",
//				"SIGNATURE BANK",
//				"STATE STREET BANK AND TRUST COMPANY",
//				"SOUTHWEST BANK OF TEXAS, N.A.",
//				"SUNTRUST BANK",
//				"U.S. BANK NATIONAL ASSOCIATION",
//				"WACHOVIA BANK, NATIONAL ASSOCIATION",
//				"WELLS FARGO BANK, NATIONAL ASSOCIATION",
//				};

	
	return values;
}

	
	
	public static ArrayList<Bank> getBanks()
	{
		
		
		//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<WITH ICE TRUST>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		

		
//		Q1 2004 Full Network
		
		//2004Q1 Full Network Names and IDRSSDs
//		//Full Names Gross Fair Value

//		String [] name = {
//				"BANK LEUMI USA",
//		"BANK OF AMERICA",
//		"BANK OF NEW YORK",
//		"BANK ONE",
//		"DEUTSCHE BANK",
//		"CITIBANK",
//		"CITIZENS BANK OF CONNECTICUT",
//		"CITIZENS BANK OF MASSACHUSETTS",
//		"CITIZENS BANK OF PENNSYLVANIA",
//		"CITIZENS BANK",
//		"ENTERPRISE NATIONAL BANK OF PALM BEACH",
//		"WACHOVIA BANK",
//		"FLEET NATIONAL BANK",
//		"HSBC BANK USA",
//		"JPMORGAN CHASE BANK",
//		"KEYBANK",
//		"MELLON BANK",
//		"MERRILL LYNCH BANK USA",
//		"MIDWEST BANK AND TRUST COMPANY",
//		"NORTHERN TRUST COMPANY",
//		"PNC BANK",
//		"SUNTRUST BANK",
//		"U.S. BANK",
//		"WELLS FARGO BANK"
//
//				};
//
//		
//		String [] nameShort = {
//				"BANK LEUMI",
//				"BANK OF AMERICA",
//				"BONY",
//				"BANK ONE",
//				"DEUTSCHE",
//				"CITIBANK",
//				"CITIZENS CT",
//				"CITIZENS MA",
//				"CITIZENS PA",
//				"CITIZENS BANK",
//				"ENTERPRISE NBPB",
//				"WACHOVIA",
//				"FLEET NATIONAL",
//				"HSBC",
//				"JPMORGAN",
//				"KEYBANK",
//				"MELLON",
//				"MERRILL",
//				"MIDWEST BTC",
//				"NORTHERN TRUST",
//				"PNC",
//				"SUNTRUST",
//				"U.S. BANK",
//				"WELLS FARGO",
//		};
//
//		int [] cert = {
//				101019,
//				480228,
//				541101,
//				173333,
//				214807,
//				476810,
//				586205,
//				14409,
//				3041974,
//				856748,
//				1444580,
//				484422,
//				76201,
//				413208,
//				852218,
//				280110,
//				934329,
//				1225800,
//				968436,
//				210434,
//				817824,
//				675332,
//				504713,
//				451965
//		};
//
//		
//		double [] B = {
//		0,
//		0.486323,
//		0.000054,
//		0.026,
//		0.063,
//		0.358,
//		0,
//		0.000044,
//		0.000285,
//		0.000001,
//		0.000758,
//		0.192,
//		0.09,
//		0.109895,
//		2.938,
//		0.000365,
//		0.001647,
//		0.000005,
//		0.013769,
//		0.000656,
//		0.000801,
//		0.00065,
//		0.000009,
//		0.004
//		};
//
//		double [] G = {
//		0.000054,
//		0.220399,
//		0,
//		0.019,
//		0,
//		0.333,
//		0.000083,
//		0.000218,
//		0.000354,
//		0,
//		0,
//		0.061,
//		0.061,
//		0.044287,
//		1.714,
//		0.000306,
//		0,
//		0,
//		0,
//		0,
//		0,
//		0.00048,
//		0.000013,
//		0.004
//				};
//
//		double [] CC = {
//		0.345793,
//		43.315395,
//		5.253917,
//		16.885,
//		6.832,
//		38.266,
//		0.210826,
//		1.455535,
//		1.331483,
//		0.025869,
//		0.010572,
//		20.758,
//		14.881,
//		5.916696,
//		35.179,
//		5.340026,
//		2.082593,
//		4.639601,
//		0.169177,
//		1.990037,
//		5.056791,
//		9.077824,
//		11.153763,
//		22.77
//				};
//
//
//		double [] MBS = {
//		1.257215,	//BANK LEUMI USA
//		128.936005,	 //BoA
//		19.916491,	 //Bank of New York Mellon
//		32.928,	//BANK ONE, NATIONAL ASSOCIATION
//		0.005,	 //Deutsche Bank Americas
//		13.235,	 //Citi
//		0.879594,	//CITIZENS BANK OF CT
//		7.313807,	//CITIZENS BANK OF MASSACHUSETTS
//		7.643677,	//CITIZENS BANK OF PENNSYLVANIA
//		0.10086,	//CITIZENS BANK
//		0.879594,	//ENTERPRISE NATIONAL BANK OF PALM BEACH
//		71.136,	 //Wachovia
//		0.017661,	//FLEET NATIONAL BANK
//		2.085744164,	 //HSBC USA
//		37.838,	 //JPMorgan
//		6.991904,	 //Keybank
//		7.150612,	 //MELLON BANK, N.A.
//		0.049509,	 //Merrill Lynch USA
//		5.198834,	 //MIDWEST
//		0.007835,	 //Northern Trust
//		0.017661,	 //PNC
//		13.043094,	 //SunTrust
//		42.113661,	 //U.S. Bank
//		23.364	 //Wells Fargo
//          };
//
//		double [] SPV = {
//		0,	//BANK LEUMI USA	
//		0.654294,	 //BoA	
//		0,	 //Bank of New York Mellon	
//		0,	//BANK ONE, NATIONAL ASSOCIATION	
//		0,	 //Deutsche Bank Americas	
//		0,	 //Citi	
//		0,	//CITIZENS BANK OF CT	
//		0,	//CITIZENS BANK OF MASSACHUSETTS	
//		0,	//CITIZENS BANK OF PENNSYLVANIA	
//		0,	//CITIZENS BANK	
//		0,	//ENTERPRISE NATIONAL BANK OF PALM BEACH	
//		2.042,	 //Wachovia	
//		0,	//FLEET NATIONAL BANK	
//		0.014662,	 //HSBC USA	
//		0.433,	 //JPMorgan	
//		0,	 //Keybank	
//		0,	 //MELLON BANK, N.A.	
//		0,	 //Merrill Lynch USA	
//		0,	 //MIDWEST	
//		0,	 //Northern Trust	
//		0,	 //PNC	
//		0.001519,	 //SunTrust	
//		0.000289,	 //U.S. Bank	
//		0.168	 //Wells Fargo	
//				         };
//
//		double [] ReferenceEntityGross = {
//		0,	//BANK LEUMI USA
//		51.947,	 //BoA
//		0,	 //Bank of New York Mellon
//		0,	//BANK ONE, NATIONAL ASSOCIATION
//		68.481,	 //Deutsche Bank Americas
//		66.637,	 //Citi
//		0,	//CITIZENS BANK OF CT
//		0,	//CITIZENS BANK OF MASSACHUSETTS
//		0,	//CITIZENS BANK OF PENNSYLVANIA
//		0,	//CITIZENS BANK
//		0,	//ENTERPRISE NATIONAL BANK OF PALM BEACH
//		45.921,	 //Wachovia
//		0,	//FLEET NATIONAL BANK
//		26.6,	 //HSBC USA
//		63.358,	 //JPMorgan
//		0,	 //Keybank
//		0,	 //MELLON BANK, N.A.
//		95.031,	 //Merrill Lynch USA
//		0,	 //MIDWEST
//		0,	 //Northern Trust
//		0,	 //PNC
//		0,	 //SunTrust
//		0,	 //U.S. Bank
//		46.177	 //Wells Fargo
//
//		         }; 
//
//		double [] ReferenceEntityNet = {
//		0,	//BANK LEUMI USA
//		3.964797707,	 //BoA
//		0,	 //Bank of New York Mellon
//		0,	//BANK ONE, NATIONAL ASSOCIATION
//		8.608297866,	 //Deutsche Bank Americas
//		4.461130826,	 //Citi
//		0,	//CITIZENS BANK OF CT
//		0,	//CITIZENS BANK OF MASSACHUSETTS
//		0,	//CITIZENS BANK OF PENNSYLVANIA
//		0,	//CITIZENS BANK
//		0,	//ENTERPRISE NATIONAL BANK OF PALM BEACH
//		3.400942586,	 //Wachovia
//		0,	//FLEET NATIONAL BANK
//		2.085744164,	 //HSBC USA
//		4.45676969,	 //JPMorgan
//		0,	 //Keybank
//		0,	 //MELLON BANK, N.A.
//		6.183012547,	 //Merrill Lynch USA
//		0,	 //MIDWEST
//		0,	 //Northern Trust
//		0,	 //PNC
//		0,	 //SunTrust
//		0,	 //U.S. Bank
//		3.441138055	 //Wells Fargo
//		         }; 
		

		
		//2006Q4 Full Network Names and IDRSSDs
		//Gross Fair Value
//		String [] name = {
//				"BANK OF AMERICA",
//				"BANK OF NEW YORK",
//				"DEUTSCHE BANK",
//				"BRANCH BANKING AND TRUST COMPANY",
//				"CALIFORNIA BANK & TRUST",
//				"CHARTER ONE BANK",
//				"CITIBANK",
//				"CITIZENS BANK NEW HAMPSHIRE",
//				"CITIZENS BANK OF MASSACHUSETTS",
//				"CITIZENS BANK OF PENNSYLVANIA",
//				"COMERICA BANK",
//				"COMMERCE BANK",
//				"COMMERCEBANK",
//				"WACHOVIA BANK",
//				"HSBC BANK USA",
//				"JPMORGAN CHASE BANK",
//				"KEYBANK",
//				"MERCANTILE-SAFE DEPOSIT AND TRUST COMPANY",
//				"MERRILL LYNCH BANK USA",
//				"MORGAN STANLEY BANK",
//				"NATIONAL CITY BANK",
//				"NORTHERN TRUST COMPANY",
//				"PNC BANK",
//				"REGIONS BANK",
//				"SUNTRUST BANK",
//				"U.S. BANK",
//				"WELLS FARGO BANK"
//				};
//		
//		
//		
//		String [] nameShort = {
//				"BANK OF AMERICA",
//				"BONY",
//				"DEUTSCHE BANK",
//				"BRANCH BANKING",
//				"CALIFORNIA BT",
//				"CHARTER ONE BANK",
//				"CITIBANK",
//				"CITIZENS BANK HA",
//				"CITIZENS BANK MA",
//				"CITIZENS BANK PA",
//				"COMERICA",
//				"COMMERCE BANK",
//				"COMMERCEBANK",
//				"WACHOVIA",
//				"HSBC",
//				"JPMORGAN",
//				"KEYBANK",
//				"MERCANTILE-SAFE",
//				"MERRILL",
//				"MORGAN STANLEY",
//				"NATIONAL CITY",
//				"NORTHERN TRUST",
//				"PNC",
//				"REGIONS",
//				"SUNTRUST",
//				"U.S. BANK",
//				"WELLS FARGO"
//				};
//
//		int [] cert = {
//				480228,
//				541101,
//				214807,
//				852320,
//				837260,
//				897273,
//				476810,
//				62101,
//				14409,
//				3041974,
//				60143,
//				363415,
//				83638,
//				484422,
//				413208,
//				852218,
//				280110,
//				208927,
//				1225800,
//				1456501,
//				259518,
//				210434,
//				817824,
//				233031,
//				675332,
//				504713,
//				451965
//
//				};
//
//		
//		double [] B = {
//				2.446942,
//				0.002,
//				0.017,
//				0.000003,
//				0,
//				0,
//				3.262,
//				0.000016,
//				0.000064,
//				0.000278,
//				0.000316,
//				0,
//				0.000057,
//				0.14,
//				1.66983,
//				14.934,
//				0.009204,
//				0.000006,
//				0.000561,
//				0.000891,
//				0.003652,
//				0.000163,
//				0.000682,
//				0.000133,
//				0.002296,
//				0.00021,
//				0.001
//
//				};
//
//		
//		double [] G = {
//				2.579127,
//				0,
//				0,
//				0.003305,
//				0.000137,
//				0.000352,
//				3.554,
//				0,
//				0.00049,
//				0.000261,
//				0.001383,
//				0.000372,
//				0.000052,
//				0.571,
//				1.926343,
//				10.25,
//				0.009582,
//				0,
//				0,
//				0,
//				0.002047,
//				0,
//				0.000127,
//				0,
//				0,
//				0.000479,
//				0.002
//				};
//
//		double [] CC = {
//				76.173682,
//				5.719,
//				7.997,
//				8.075202,
//				0.7511,
//				2.616928,
//				59.86,
//				0.743758,
//				2.492098,
//				2.252895,
//				5.693248,
//				2.406482,
//				0.378797,
//				32.981,
//				10.278171,
//				68.726,
//				6.818689,
//				0.61761,
//				5.524426,
//				2.810983,
//				8.385728,
//				2.804643,
//				6.159034,
//				11.095684,
//				12.831702,
//				12.359749,
//				29.222
//				};
//
//
//		double [] MBS = {
//				163.181138,
//				17.709,
//				0.005,
//				9.867966,
//				0.064341,
//				4.191419,
//				90.538,
//				2.725744,
//				5.885818,
//				7.866024,
//				3.515627,
//				1.113247,
//				1.113247,
//				80.547,
//				16.695231,
//				75.49,
//				7.325893,
//				0.838848,
//				18.176764,
//				0.04009,
//				4.861431,
//				0.046544,
//				19.954824,
//				12.729731,
//				17.130437,
//				33.626351,
//				30.981
//				           };
//		
//		double [] SPV = {
//				0.412154,
//				0,
//				0,
//				0.066646,
//				0,
//				0.00043,
//				0.459,
//				0,
//				0,
//				0,
//				0,
//				0,
//				0,
//				4.684,
//				0.007716,
//				0.662,
//				0,
//				0.000012,
//				0,
//				0,
//				0.321822,
//				0,
//				0,
//				0.309533,
//				0,
//				0.637825,
//				0
//				         };
//		
//		double [] ReferenceEntityGross = {
//				0,
//				51.947,
//				0,
//				0,
//				0,
//				0,
//				66.637,
//				0,
//				0,
//				0,
//				0,
//				0,
//				0,
//				45.921,
//				26.6,
//				63.358,
//				0,
//				0,
//				95.031,
//				93.274,
//				0,
//				0,
//				0,
//				0,
//				0,
//				0,
//				46.177
//		         }; 
//		
//		double [] ReferenceEntityNet = {
//				0,
//				3.964797707,
//				0,
//				0,
//				0,
//				0,
//				4.461130826,
//				0,
//				0,
//				0,
//				0,
//				0,
//				0,
//				3.400942586,
//				2.085744164,
//				4.45676969,
//				0,
//				0,
//				6.183012547,
//				4.45676969,
//				0,
//				0,
//				0,
//				0,
//				0,
//				0,
//				3.441138055
//		         }; 

		

		
////	Q4 2007 Full Network
//		Gross Fair Value
//	//2007Q4 Full Network Names and IDRSSDs
//	String [] name = {
//		"BANK LEUMI USA",
//		"BANK OF AMERICA",
//		"BANK OF NEW YORK",
//		"BANK OF TOKYO-MITSUBISHI TRUST COMPANY",
//		"DEUTSCHE BANK",
//		"BRANCH BANKING AND TRUST COMPANY",
//		"CALIFORNIA BANK & TRUST",
//		"CITIBANK",
//		"CITIZENS BANK OF PENNSYLVANIA",
//		"COMERICA BANK",
//		"COMMERCE BANK",
//		"WACHOVIA BANK",
//		"GOLDMAN SACHS BANK USA",
//		"HORICON STATE BANK",
//		"HSBC BANK USA",
//		"JOHNSON BANK",
//		"JPMORGAN CHASE BANK",
//		"KEYBANK",
//		"LASALLE BANK",
//		"MERRILL LYNCH BANK USA",
//		"MORGAN STANLEY BANK",
//		"NATIONAL CITY BANK",
//		"NORTHERN TRUST COMPANY",
//		"PNC BANK",
//		"RBS CITIZENS",
//		"REGIONS BANK",
//		"STANDARD FEDERAL BANK",
//		"STATE STREET BANK AND TRUST COMPANY",
//		"SUNTRUST BANK",
//		"U.S. BANK",
//		"WELLS FARGO BANK"
//			};
//	
//	String [] nameShort = {
//		"BANK LEUMI",
//		"BANK OF AMERICA",
//		"BONY",
//		"TOKYO-MITSUBISHI",
//		"DEUTSCHE",
//		"BRANCH BANKING",
//		"CALIFORNIA BT",
//		"CITIBANK",
//		"CITIZENS PA",
//		"COMERICA",
//		"COMMERCE BANK",
//		"WACHOVIA BANK",
//		"GOLDMAN",
//		"HORICON",
//		"HSBC",
//		"JOHNSON",
//		"JPMORGAN",
//		"KEYBANK",
//		"LASALLE BANK",
//		"MERRILL",
//		"MORGAN STANLEY",
//		"NATIONAL CITY",
//		"NORTHERN TRUST",
//		"PNC",
//		"RBS CITIZENS",
//		"REGIONS",
//		"STANDARD FEDERAL",
//		"STATE STREET",
//		"SUNTRUST",
//		"U.S. BANK",
//		"WELLS FARGO"
//	};
//
//	int [] cert = {
//		101019,
//		480228,
//		541101,
//		968605,
//		214807,
//		852320,
//		837260,
//		476810,
//		3041974,
//		60143,
//		363415,
//		484422,
//		3278305,
//		528849,
//		413208,
//		58243,
//		852218,
//		280110,
//		455534,
//		1225800,
//		1456501,
//		259518,
//		210434,
//		817824,
//		3303298,
//		233031,
//		445843,
//		35301,
//		675332,
//		504713,
//		451965
//	};
//	
//	double [] B = {
//		0,
//		52.116625,
//		0.038,
//		0,
//		0.382,
//		0.000003,
//		0,
//		71.857,
//		0.000034,
//		0.000764,
//		0,
//		8.997,
//		0.007502,
//		0,
//		17.930999,
//		0,
//		115.151,
//		0.046945,
//		0.000462,
//		0.229945,
//		0.267,
//		0.009013,
//		0.002685,
//		0.096194,
//		0.000023,
//		0.002965,
//		0.000016,
//		0.000968,
//		0.022848,
//		0.001539,
//		0.042
//	};
//	
//	double [] G = {
//		0.000014,
//		47.818696,
//		0,
//		0.01623,
//		0,
//		0.004793,
//		0.000115,
//		66.701,
//		0.0005,
//		0,
//		0.002329,
//		9.397,
//		0,
//		0.000025,
//		17.504484,
//		0.000222,
//		101.764,
//		0.041625,
//		0.002384,
//		0,
//		0,
//		0.00386,
//		0,
//		0.054329,
//		0.001562,
//		0,
//		0.000275,
//		0,
//		0.012986,
//		0.001306,
//		0.021
//			};
//
//	double [] CC = {
//		0.423806,
//		75.395247,
//		6.464,
//		0.78297,
//		8.492,
//		8.469,
//		0.68938,
//		81.952,
//		2.25712,
//		5.728275,
//		2.491994,
//		40.465,
//		1.210714,
//		0.037915,
//		9.696195,
//		0.313397,
//		78.453,
//		7.139729,
//		6.837942,
//		6.511001,
//		3.149,
//		8.364876,
//		3.021495,
//		7.851373,
//		7.929699,
//		9.798731,
//		6.914771,
//		0.74263,
//		12.338339,
//		13.2067,
//		29.553
//			};
//
//	double [] MBS = {
//		0.827973,
//		172.204849,
//		25.715,
//		0.085912,
//		0.198,
//		9.93946,
//		0.048102,
//		59.864,
//		9.442993,
//		6.166904,
//		1.391062,
//		79.45,
//		0,
//		0.001571,
//		18.434512,
//		0.456988,
//		66.698,
//		7.552058,
//		0,
//		19.222152,
//		0,
//		5.159402,
//		0.646734,
//		25.595661,
//		18.961629,
//		11.042161,
//		29.59394,
//		0.241727,
//		9.93458,
//		30.460849,
//		54.344
//
//};
//////	
//	double [] SPV = {
//		0,
//		0.14995,
//		0,
//		0,
//		0,
//		0.055368,
//		0,
//		0.061,
//		0,
//		0,
//		0,
//		4.657,
//		0,
//		0.0009,
//		0.005756,
//		0,
//		0.977,
//		0,
//		0,
//		0,
//		0,
//		0.742566,
//		0,
//		0.000004,
//		0.002234,
//		0.25084,
//		0,
//		0,
//		0,
//		0.502013,
//		0
//		         
//		};
//////	
//	double [] ReferenceEntityGross = {
//		0,
//		51.947,
//		0,
//		0,
//		68.481,
//		0,
//		0,
//		66.637,
//		0,
//		0,
//		0,
//		45.921,
//		94.039,
//		0,
//		26.6,
//		0,
//		63.358,
//		0,
//		0,
//		95.031,
//		93.274,
//		0,
//		0,
//		0,
//		0,
//		0,
//		0,
//		0,
//		0,
//		0,
//		46.177
//    
//		}; 
//////	
//	double [] ReferenceEntityNet = {
//	0,
//		3.964797707,
//		0,
//		0,
//		8.608297866,
//		0,
//		0,
//		4.461130826,
//		0,
//		0,
//		0,
//		3.400942586,
//		6.20342418,
//		0,
//		2.085744164,
//		0,
//		4.45676969,
//		0,
//		0,
//		6.183012547,
//		4.45676969,
//		0,
//		0,
//		0,
//		0,
//		0,
//		0,
//		0,
//		0,
//		0,
//		3.441138055
//        }; 
//
		
		
		
		
//		Q1 2004 Full Network Gross Notional Value
		
		//2004Q1 Full Network Names and IDRSSDs
		//Full Names Gross Notional Value
		String [] name = {
				"AMSOUTH BANK",
				"BANK LEUMI USA",
				"BANK OF AMERICA, NATIONAL ASSOCIATION",
				"BANK OF NEW YORK, THE",
				"BANK OF TOKYO-MITSUBISHI TRUST COMPANY",
				"BANK ONE, NATIONAL ASSOCIATION",
				"CITIBANK, N.A.",
				"CITIZENS BANK OF CONNECTICUT",
				"CITIZENS BANK OF MASSACHUSETTS",
				"CITIZENS BANK OF PENNSYLVANIA",
				"CITIZENS BANK, THE",
				"Deutsche Bank Trust Company Americas",
				"ENTERPRISE NATIONAL BANK OF PALM BEACH",
				"FIRST AMERICAN BANK",
				"FLEET NATIONAL BANK",
				"HARRIS TRUST AND SAVINGS BANK",
				"HSBC BANK USA",
				"JPMORGAN CHASE BANK",
				"JUNIPER BANK",
				"KEYBANK NATIONAL ASSOCIATION",
				"MELLON BANK, N.A.",
				"MERRILL LYNCH BANK USA",
				"MIDWEST BANK AND TRUST COMPANY",
				"MORGAN STANLEY BANK",
				"NATIONAL CITY BANK",
				"NORTHERN TRUST COMPANY, THE",
				"PALMETTO STATE BANK",
				"PARK AVENUE BANK, NATIONAL ASSOCIATION, THE",
				"PNC BANK, NATIONAL ASSOCIATION",
				"PROVIDENT BANK, THE",
				"SUNTRUST BANK",
				"U.S. BANK NATIONAL ASSOCIATION",
				"WACHOVIA BANK, NATIONAL ASSOCIATION",
				"WELLS FARGO BANK, NATIONAL ASSOCIATION",
				"WELLS FARGO HSBC TRADE BANK, NATIONAL ASSOCIATION"
				};
		
		
		
		String [] nameShort = {
				"AMSOUTH",
				"BANK LEUMI",
				"BANK OF AMERICA",
				"BONY",
				"TOKYO-MITSUBISHI",
				"BANK ONE",
				"CITIBANK",
				"CITIZENS CT",
				"CITIZENS MA",
				"CITIZENS PA",
				"CITIZENS",
				"DEUTSCHE",
				"ENTERPRISE",
				"FIRST AMERICAN",
				"FLEET NATIONAL",
				"HARRIS",
				"HSBC",
				"JPMORGAN",
				"JUNIPER",
				"KEYBANK",
				"MELLON",
				"MERRILL LYNCH",
				"MIDWEST BANK",
				"MORGAN STANLEY",
				"NATIONAL CITY",
				"NORTHERN TRUST",
				"PALMETTO",
				"PARK AVENUE",
				"PNC BANK",
				"PROVIDENT",
				"SUNTRUST",
				"U.S. BANK",
				"WACHOVIA",
				"WELLS FARGO",
				"WELLS FARGO HSBC"
		};

		int [] cert = {
				245333,
				101019,
				480228,
				541101,
				968605,
				173333,
				476810,
				586205,
				14409,
				3041974,
				856748,
				214807,
				1444580,
				653648,
				76201,
				75633,
				413208,
				852218,
				2980209,
				280110,
				934329,
				1225800,
				968436,
				1456501,
				259518,
				210434,
				277820,
				1160152,
				817824,
				612618,
				675332,
				504713,
				484422,
				451965,
				2332808
		};

		
		double [] B = {
				0.006,
				0,
				101.546772,
				0.770112,
				0.005,
				14.921,
				116.862,
				0,
				0.000174,
				0.001573,
				0.02,
				2.156,
				1.1554,
				0,
				15.891,
				0,
				22.129111,
				330.055,
				0.03428,
				0.234,
				0.608789,
				0.04,
				3.465456,
				0,
				0.093133,
				0.0825,
				0.000071,
				0,
				0.175625,
				0.837115,
				0.267,
				0.127366,
				23.955,
				1.652,
				0
		};

		
		double [] G = {
				0,
				0.075,
				66.829707,
				0.52738,
				0,
				12.432,
				125.133,
				0.000071,
				0.001392,
				0.018917,
				0,
				0,
				0,
				0.000707,
				13.872,
				0.03881,
				27.872542,
				292.791,
				0,
				0.215,
				0,
				0,
				0.569335,
				0.010918,
				0.064543,
				0,
				0,
				0.01,
				0,
				0,
				0.285,
				0.063626,
				22.885,
				1.637,
				0.00004
				};

		double [] CC = {
				3.338482,
				0.345793,
				43.315395,
				5.253917,
				0.785923,
				16.885,
				38.266,
				0.210826,
				1.455535,
				1.331483,
				0.025869,
				6.832,
				0.010572,
				0.070136,
				14.881,
				1.676763,
				5.916696,
				35.179,
				0.055142,
				5.340026,
				2.082593,
				4.639601,
				0.169177,
				1.531623,
				2.980211,
				1.990037,
				0.02467,
				0.013899,
				5.056791,
				1.219954,
				9.077824,
				11.153763,
				20.758,
				22.77,
				0.094429
				};


		double [] MBS = {
				11.536955,
				1.257215,
				128.936005,
				19.916491,
				0.102811,
				32.928,
				13.235,
				0.879594,
				7.313807,
				7.643677,
				0.10086,
				0.005,
				0.089994,
				0.049179,
				24.005,
				0.255007,
				12.761394,
				37.838,
				0.052733,
				6.991904,
				7.150612,
				0.049509,
				5.198834,
				0,
				1.631911,
				0.007835,
				0.028519,
				0.017661,
				8.646224,
				3.433514,
				13.043094,
				42.113661,
				71.136,
				23.364,
				0.003577

          };
		
		double [] SPV = {
				0.047307,
				0,
				0.654294,
				0,
				0,
				0,
				0,
				0,
				0,
				0,
				0,
				0,
				0,
				0,
				0.159,
				0.006971,
				0.014662,
				0.433,
				0,
				0,
				0,
				0,
				0,
				0,
				0.000128,
				0,
				0,
				0,
				0.00928,
				0.001519,
				0,
				0.000289,
				2.042,
				0.168,
				0
				         };
		
		double [] ReferenceEntityGross = {
				0,	 //AMSOUTH BANK
				0,	//BANK LEUMI USA
				51.947,	 //BoA
				0,	 //Bank of New York Mellon
				0,	 //Mitsubishi UFJ
				0,	//BANK ONE, NATIONAL ASSOCIATION
				66.637,	 //Citi
				0,	//CITIZENS BANK OF CT
				0,	//CITIZENS BANK OF MASSACHUSETTS
				0,	//CITIZENS BANK OF PENNSYLVANIA
				0,	//CITIZENS BANK
				68.481,	 //Deutsche Bank Americas
				0,	 //Comerica
				0,	 //Commerce
				0,	 //LASALLE BANK NATIONAL ASSOCIATION
				0,	//CALIFORNIA BANK & TRUST
				26.6,	 //HSBC USA
				63.358,	 //JPMorgan
				0,	//JUNIPER
				0,	 //Keybank
				0,	 //MELLON BANK, N.A.
				95.031,	 //Merrill Lynch USA
				0,	 //MIDWEST
				93.274,	 //Morgan Stanley
				0,	 //National City
				0,	 //Northern Trust
				0,	 //Northern Trust
				0,	 //PNC
				0,	 //Regions
				0,	 //State Street and Trust
				0,	 //SunTrust
				0,	 //U.S. Bank
				45.921,	 //Wachovia
				46.177,	 //Wells Fargo
				0	//CHARTER ONE BANK, NATIONAL ASSOCIATION


		         }; 
		
		double [] ReferenceEntityNet = {
				0,	 //AMSOUTH BANK
				0,	//BANK LEUMI USA
				3.964797707,	 //BoA
				0,	 //Bank of New York Mellon
				0,	 //Mitsubishi UFJ
				0,	//BANK ONE, NATIONAL ASSOCIATION
				4.461130826,	 //Citi
				0,	//CITIZENS BANK OF CT
				0,	//CITIZENS BANK OF MASSACHUSETTS
				0,	//CITIZENS BANK OF PENNSYLVANIA
				0,	//CITIZENS BANK
				8.608297866,	 //Deutsche Bank Americas
				0,	 //Comerica
				0,	 //Commerce
				0,	 //LASALLE BANK NATIONAL ASSOCIATION
				0,	//CALIFORNIA BANK & TRUST
				2.085744164,	 //HSBC USA
				4.45676969,	 //JPMorgan
				0,	//JUNIPER
				0,	 //Keybank
				0,	 //MELLON BANK, N.A.
				6.183012547,	 //Merrill Lynch USA
				0,	 //MIDWEST
				4.45676969,	 //Morgan Stanley
				0,	 //National City
				0,	 //Northern Trust
				0,	 //Northern Trust
				0,	 //PNC
				0,	 //Regions
				0,	 //State Street and Trust
				0,	 //SunTrust
				0,	 //U.S. Bank
				3.400942586,	 //Wachovia
				3.441138055,	 //Wells Fargo
				0	//CHARTER ONE BANK, NATIONAL ASSOCIATION

		         }; 
		
		
		
		

		
		
		//		Q4 2006 Full Network
//		
//		//2006Q4 Full Network Names and IDRSSDs
//		String [] name = {
//				"BANK LEUMI USA",
//				"BANK OF AMERICA",
//				"BANK OF NEW YORK",
//				"BANK OF TOKYO-MITSUBISHI TRUST COMPANY",
//				"BRANCH BANKING AND TRUST COMPANY",
//				"CALIFORNIA BANK & TRUST",
//				"CHARTER ONE BANK",
//				"CITIBANK",
//				"CITIZENS BANK NEW HAMPSHIRE",
//				"CITIZENS BANK OF MASSACHUSETTS",
//				"CITIZENS BANK OF PENNSYLVANIA",
//				"COMERICA BANK",
//				"COMMERCE BANK",
//				"COMMERCEBANK",
//				"DEUTSCHE BANK",
//				"HSBC",
//				"JPMORGAN",
//				"KEYBANK",
//				"LASALLE BANK",
//				"MELLON BANK",
//				"MERCANTILE-SAFE DEPOSIT AND TRUST COMPANY",
//				"MERRILL LYNCH",
//				"MORGAN STANLEY",
//				"NATIONAL CITY",
//				"NORTHERN TRUST COMPANY",
//				"PNC BANK",
//				"REGIONS BANK",
//				"STATE STREET BANK AND TRUST COMPANY",
//				"SUNTRUST BANK",
//				"U.S. BANK",
//				"WACHOVIA",
//				"WELLS FARGO"
//				};
//		
//		
//		
//		String [] nameShort = {
//				"BANK LEUMI",
//				"BANK OF AMERICA",
//				"BONY",
//				"TOKYO-MITSUBISHI",
//				"BRANCH BANKING",
//				"CALIFORNIA B&T",
//				"CHARTER ONE",
//				"CITIBANK",
//				"CITIZENS HA",
//				"CITIZENS MA",
//				"CITIZENS PA",
//				"COMERICA",
//				"COMMERCE BANK",
//				"COMMERCEBANK",
//				"DEUTSCHE",
//				"HSBC",
//				"JPMORGAN",
//				"KEYBANK",
//				"LASALLE BANK",
//				"MELLON BANK",
//				"MERCANTILE-SAFE",
//				"MERRILL LYNCH",
//				"MORGAN STANLEY",
//				"NATIONAL CITY",
//				"NORTHERN TRUST",
//				"PNC BANK",
//				"REGIONS BANK",
//				"STATE STREET",
//				"SUNTRUST",
//				"U.S. BANK",
//				"WACHOVIA",
//				"WELLS FARGO"
//				};
//
//		int [] cert = {
//				101019,
//				480228,
//				541101,
//				968605,
//				852320,
//				837260,
//				897273,
//				476810,
//				62101,
//				14409,
//				3041974,
//				60143,
//				363415,
//				83638,
//				214807,
//				413208,
//				852218,
//				280110,
//				455534,
//				934329,
//				208927,
//				1225800,
//				1456501,
//				259518,
//				210434,
//				817824,
//				233031,
//				35301,
//				675332,
//				504713,
//				484422,
//				451965
//				};
//
//		
//		double [] B = {
//				0,
//				704.57988,
//				1.655,
//				0.025,
//				0.015003,
//				0,
//				0,
//				833.701,
//				0.000067,
//				0.000405,
//				0.001001,
//				0.007995,
//				0,
//				0.074,
//				5.914,
//				375.50752,
//				2318.54,
//				4.319705,
//				0.285,
//				0.320518,
//				0.001726,
//				6.170762,
//				6.83609,
//				0.927408,
//				0.30025,
//				2.72005,
//				0.02,
//				0.155,
//				0.634419,
//				0.025,
//				160.155,
//				0.914
//				};
//
//		
//		double [] G = {
//				0.055,
//				745.502945,
//				0,
//				0.15,
//				0.031703,
//				0.000038,
//				0.000757,
//				772.315,
//				0,
//				0.001292,
//				0.000366,
//				0.007546,
//				0.017684,
//				0.028,
//				0,
//				424.468407,
//				2291.867,
//				3.356205,
//				0,
//				0,
//				0,
//				0,
//				0,
//				0.620103,
//				0,
//				1.071,
//				0,
//				0,
//				0.323419,
//				0,
//				148.61,
//				0.596
//				};
//
//		double [] CC = {
//				0.396025,
//				76.173682,
//				5.719,
//				0.828328,
//				8.075202,
//				0.7511,
//				2.616928,
//				59.86,
//				0.743758,
//				2.492098,
//				2.252895,
//				5.693248,
//				2.406482,
//				0.378797,
//				7.997,
//				10.278171,
//				68.726,
//				6.818689,
//				6.658037,
//				2.103811,
//				0.61761,
//				5.524426,
//				2.810983,
//				8.385728,
//				2.804643,
//				6.159034,
//				11.095684,
//				5.473466,
//				12.831702,
//				12.359749,
//				32.981,
//				29.222
//				};
//
//
//		double [] MBS = {
//				0.916238,
//				163.181138,
//				17.709,
//				0.11937,
//				9.867966,
//				0.064341,
//				4.191419,
//				90.538,
//				2.725744,
//				5.885818,
//				7.866024,
//				3.515627,
//				1.113247,
//				16.695231,
//				75.49,
//				7.325893,
//				10.300819,
//				11.067413,
//				0.838848,
//				0.04009,
//				0.04009,
//				18.176764,
//				0.04009,
//				4.861431,
//				0.046544,
//				19.954824,
//				12.729731,
//				23.360521,
//				17.130437,
//				33.626351,
//				80.547,
//				30.981
//				           };
//		
//		double [] SPV = {
//				0,
//				0.412154,
//				0,
//				0,
//				0.066646,
//				0,
//				0.00043,
//				0.459,
//				0,
//				0,
//				0,
//				0,
//				0,
//				0.007716,
//				0.662,
//				0,
//				0,
//				0.000012,
//				0,
//				0,
//				0,
//				0,
//				0,
//				0.321822,
//				0,
//				0,
//				0.309533,
//				0,
//				0,
//				0.637825,
//				4.684,
//				0
//				         };
//		
//		double [] ReferenceEntityGross = {
//				0,	//BANK LEUMI USA
//				51.947,	 //BoA
//				0,	 //Bank of New York Mellon
//				0,	 //Mitsubishi UFJ
//				0,	//BRANCH BANKING AND TRUST COMPANY
//				0,	//CALIFORNIA BANK & TRUST
//				0,	
//				66.637,	 //Citi
//				0,	
//				0,	//CITIZENS BANK OF PENNSYLVANIA
//				0,	 //Comerica
//				0,	 //Commerce
//				0,	
//				0,	
//				68.481,	 //Deutsche Bank Americas
//				26.6,	 //HSBC USA
//				63.358,	 //JPMorgan
//				0,	 //Keybank
//				0,	
//				0,	
//				0,	
//				95.031,	 //Merrill Lynch USA
//				93.274,	 //Morgan Stanley
//				0,	 //National City
//				0,	 //Northern Trust
//				0,	 //PNC
//				0,	 //Regions
//				0,	 //State Street and Trust
//				0,	 //SunTrust
//				0,	 //U.S. Bank
//				45.921,	 //Wachovia
//				46.177	 //Wells Fargo
//		         }; 
//		
//		double [] ReferenceEntityNet = {
//				0,	//BANK LEUMI USA
//				3.964797707,	 //BoA
//				0,	 //Bank of New York Mellon
//				0,	//Mitsubishi UFJ
//				0,	//BRANCH BANKING AND TRUST COMPANY
//				0,	//CALIFORNIA BANK & TRUST
//				0,	
//				4.461130826,	 //Citi
//				0,	
//				0,	//CITIZENS BANK OF PENNSYLVANIA
//				0,	 //Comerica
//				0,	 //Commerce
//				0,	
//				0,	
//				8.608297866,	 //Deutsche Bank Americas
//				2.085744164,	 //HSBC USA
//				4.45676969,	 //JPMorgan
//				0,	 //Keybank
//				0,	
//				0,	
//				0,	
//				6.183012547,	 //Merrill Lynch USA
//				4.45676969,	 //Morgan Stanley
//				0,	 //National City 
//				0,	 //Northern Trust
//				0,	 //PNC
//				0,	 //Regions
//				0,	 //State Street and Trust
//				0,	 //SunTrust
//				0,	 //U.S. Bank
//				3.400942586,	 //Wachovia
//				3.441138055	 //Wells Fargo
//		         }; 
		

		
		
		
////		Q4 2007 Full Network
//		
//		//2007Q4 Full Network Names and IDRSSDs
//		String [] name = {
//		"BANK LEUMI USA",
//		"BANK OF AMERICA, NATIONAL ASSOCIATION",
//		"BANK OF NEW YORK, THE",
//		"BANK OF TOKYO-MITSUBISHI TRUST COMPANY",
//		"BRANCH BANKING AND TRUST COMPANY",
//		"CALIFORNIA BANK & TRUST",
//		"CITIBANK, N.A.",
//		"CITIZENS BANK OF PENNSYLVANIA",
//		"COMERICA BANK",
//		"COMMERCEBANK, NATIONAL ASSOCIATION",
//		"Deutsche Bank Trust Company Americas",
//		"GOLDMAN SACHS BANK USA",
//		"HORICON STATE BANK",
//		"HSBC BANK USA",
//		"JOHNSON BANK",
//		"JPMORGAN CHASE BANK",
//		"KEYBANK NATIONAL ASSOCIATION",
//		"MERRILL LYNCH BANK USA",
//		"MORGAN STANLEY BANK",
//		"NATIONAL CITY BANK",
//		"NORTHERN TRUST COMPANY, THE",
//		"PNC BANK, NATIONAL ASSOCIATION",
//		"RBS CITIZENS, NATIONAL ASSOCIATION",
//		"REGIONS BANK",
//		"SOUTHWEST BANK OF TEXAS, N.A.",
//		"STANDARD FEDERAL BANK NATIONAL ASSOCIATION",
//		"STATE STREET BANK AND TRUST COMPANY",
//		"SUNTRUST BANK",
//		"U.S. BANK NATIONAL ASSOCIATION",
//		"WACHOVIA BANK, NATIONAL ASSOCIATION",
//		"WELLS FARGO BANK, NATIONAL ASSOCIATION"
//				};
//
//		String [] nameShort = {
//		"BANK LEUMI",
//		"BANK OF AMERICA",
//		"BONY",
//		"TOKYO-MITSUBISHI",
//		"BRANCH BANKING",
//		"CALIFORNIA B&T",
//		"CITIBANK",
//		"CITIZENS PA",
//		"COMERICA",
//		"COMMERCEBANK",
//		"DEUTSCHE",
//		"GOLDMAN",
//		"HORICON",
//		"HSBC",
//		"JOHNSON",
//		"JPMORGAN",
//		"KEYBANK",
//		"MERRILL LYNCH",
//		"MORGAN STANLEY",
//		"NATIONAL CITY",
//		"NORTHERN TRUST",
//		"PNC BANK",
//		"RBS CITIZENS",
//		"REGIONS BANK",
//		"SOUTHWEST TX",
//		"STANDARD FEDERAL",
//		"STATE STREET",
//		"SUNTRUST",
//		"U.S. BANK",
//		"WACHOVIA",
//		"WELLS FARGO"
//		};
//
//
//		int [] cert = {
//		101019,
//		480228,
//		541101,
//		968605,
//		852320,
//		837260,
//		476810,
//		3041974,
//		60143,
//		83638,
//		214807,
//		2182786,
//		528849,
//		413208,
//		58243,
//		852218,
//		280110,
//		1225800,
//		1456501,
//		259518,
//		210434,
//		817824,
//		3303298,
//		233031,
//		676656,
//		445843,
//		35301,
//		675332,
//		504713,
//		484422,
//		451965
//		};
//
//		double [] B = {
//		0,
//		1483.958464,
//		2.089,
//		0.01,
//		0.010002,
//		0,
//		1610.324,
//		0.000138,
//		0.010683,
//		0.0135,
//		0.1,
//		0.555,
//		0,
//		586.646669,
//		0,
//		4016.58,
//		4.346627,
//		8.728016,
//		15.322,
//		1.384731,
//		0.27875,
//		3.956,
//		0.000051,
//		0.072051,
//		0,
//		2.097736,
//		0.2375,
//		0.781419,
//		0.0555,
//		179.633,
//		1.88
//		};
//
//		double [] G = {
//		0.01,
//		1522.460858,
//		0.002,
//		0.15,
//		0.068821,
//		0.000221,
//		1505.618,
//		0.003601,
//		0.006089,
//		0.094301,
//		0,
//		0,
//		0.006,
//		638.067652,
//		0.00857,
//		3860.565,
//		3.328206,
//		0,
//		0,
//		0.853729,
//		0,
//		2.0995,
//		0.022666,
//		0.130224,
//		0.000175,
//		0,
//		0,
//		0.313419,
//		0,
//		188.351,
//		0.87
//				};
//
//		double [] CC = {
//		0.423806,
//		75.395247,
//		6.464,
//		0.78297,
//		8.469,
//		0.68938,
//		81.952,
//		2.25712,
//		5.728275,
//		0.442251,
//		8.492,
//		1.210714,
//		0.037915,
//		9.696195,
//		0.313397,
//		78.453,
//		7.139729,
//		6.511001,
//		3.149,
//		8.364876,
//		3.021495,
//		7.851373,
//		7.929699,
//		9.798731,
//		2.051876,
//		6.914771,
//		0.74263,
//		12.338339,
//		13.2067,
//		40.465,
//		29.553
//				};
//
//		double [] MBS = {
//		0.827973,
//		172.204849,
//		25.715,
//		0.085912,
//		9.93946,
//		0.048102,
//		59.864,
//		9.442993,
//		6.166904,
//		1.391062,
//		0.198,
//		0,
//		0.001571,
//		18.434512,
//		0.456988,
//		66.698,
//		7.552058,
//		19.222152,
//		0,
//		5.159402,
//		0.646734,
//		25.595661,
//		18.961629,
//		11.042161,
//		0,
//		29.59394,
//		0.241727,
//		9.93458,
//		30.460849,
//		79.45,
//		54.344
//
//          };
//
//		double [] SPV = {
//		0,
//		0.14995,
//		0,
//		0,
//		0.055368,
//		0,
//		0.061,
//		0,
//		0,
//		0,
//		0,
//		0,
//		0.0009,
//		0.005756,
//		0,
//		0.977,
//		0,
//		0,
//		0,
//		0.742566,
//		0,
//		0.000004,
//		0.002234,
//		0.25084,
//		0.062656,
//		0,
//		0,
//		0,
//		0.502013,
//		4.657,
//		0
//				         };
//
//		double [] ReferenceEntityGross = {
//				0,	//BANK LEUMI USA
//		51.947,	 //BoA
//		0,	 //Bank of New York Mellon
//		0,	 //Mitsubishi UFJ
//		0,	//BRANCH BANKING AND TRUST COMPANY
//		0,	//CALIFORNIA BANK & TRUST
//		66.637,	 //Citi
//		0,	//CITIZENS BANK OF PENNSYLVANIA
//		0,	 //Comerica
//		0,	 //Commerce
//		68.481,	 //Deutsche Bank Americas
//		94.039,	 //Goldman
//		0,	//Horicon
//		26.6,	 //HSBC USA
//		0,	//JOHNSON
//		63.358,	 //JPMorgan
//		0,	 //Keybank
//		95.031,	 //Merrill Lynch USA
//		93.274,	 //Morgan Stanley
//		0,	 //National City
//		0,	 //Northern Trust
//		0,	 //PNC
//		0,	 //RBS CITIZENS
//		0,	 //Regions
//		0,	 //STANDARD
//		0,	 //State Street and Trust
//		0,	 //SOUTHWEST
//		0,	 //SunTrust
//		0,	 //U.S. Bank
//		45.921,	 //Wachovia
//		46.177	 //Wells Fargo
//		         }; 
//
//		double [] ReferenceEntityNet = {
//		0,	//BANK LEUMI USA
//		3.964797707,	 //BoA
//		0,	 //Bank of New York Mellon
//		0,	//Mitsubishi UFJ
//		0,	//BRANCH BANKING AND TRUST COMPANY
//		0,	//CALIFORNIA BANK & TRUST
//		4.461130826,	 //Citi
//		0,	//CITIZENS BANK OF PENNSYLVANIA
//		0,	 //Comerica
//		0,	 //Commerce
//		8.608297866,	 //Deutsche Bank Americas
//		6.20342418,	 //Goldman
//		0,	//Horicon
//		2.085744164,	 //HSBC USA
//		0,	//JOHNSON
//		4.45676969,	 //JPMorgan
//		0,	 //Keybank
//		6.183012547,	 //Merrill Lynch USA
//		4.45676969,	 //Morgan Stanley
//		0,	 //National City 
//		0,	 //Northern Trust
//		0,	 //PNC
//		0,	 //RBS CITIZENS
//		0,	 //Regions
//		0,	 //STANDARD
//		0,	 //State Street and Trust
//		0,	 //SOUTHWEST
//		0,	 //SunTrust
//		0,	 //U.S. Bank
//		3.400942586,	 //Wachovia
//		3.441138055	 //Wells Fargo
//		         }; 
//		
		

//		Q4 2008 Full Network
		
		//2008Q4 Full Network Names and IDRSSDs
//		String [] name = {
//		"ASSOCIATED BANK, NATIONAL ASSOCIATION",
//		"BANK LEUMI USA",
//		"BANK OF AMERICA, NATIONAL ASSOCIATION",
//		"BANK OF NEW YORK, THEv
//		"BANK OF TOKYO-MITSUBISHI TRUST COMPANY",
//		"BANKNORTH, NATIONAL ASSOCIATION",
//		"CALIFORNIA BANK & TRUST",
//		"CITIBANK, N.A.",
//		"CITIZENS BANK OF PENNSYLVANIA",
//		"COMERICA BANK",
//		"COMMERCEBANK, NATIONAL ASSOCIATION",
//		"Deutsche Bank Trust Company Americas",
//		"GOLDMAN SACHS BANK USA",
//		"HORICON STATE BANK",
//		"HSBC BANK USA",
//		"ICE TRUST U.S. LLC",
//		"JPMORGAN CHASE BANK",
//		"KEYBANK NATIONAL ASSOCIATION",
//		"MORGAN STANLEY BANK",
//		"NATIONAL CITY BANK",
//		"NORTHERN TRUST COMPANY, THE",
//		"PARK AVENUE BANK, NATIONAL ASSOCIATION, THE",
//		"PNC BANK, NATIONAL ASSOCIATION",
//		"RBS CITIZENS, NATIONAL ASSOCIATION",
//		"SIGNATURE BANK",
//		"STATE STREET BANK AND TRUST COMPANY",
//		"SOUTHWEST BANK OF TEXAS, N.A.",
//		"SUNTRUST BANK",
//		"U.S. BANK NATIONAL ASSOCIATION",
//		"WACHOVIA BANK, NATIONAL ASSOCIATION",
//		"WELLS FARGO BANK, NATIONAL ASSOCIATION"
//				};
//		
//		
//		
//		String [] nameShort = {
//		"ASSOCIATED BANK, NATIONAL ASSOCIATION",
//		"BANK LEUMI USA",
//		"BANK OF AMERICA, NATIONAL ASSOCIATION",
//		"BANK OF NEW YORK, THEv
//		"BANK OF TOKYO-MITSUBISHI TRUST COMPANY",
//		"BANKNORTH, NATIONAL ASSOCIATION",
//		"CALIFORNIA BANK & TRUST",
//		"CITIBANK, N.A.",
//		"CITIZENS BANK OF PENNSYLVANIA",
//		"COMERICA BANK",
//		"COMMERCEBANK, NATIONAL ASSOCIATION",
//		"Deutsche Bank Trust Company Americas",
//		"GOLDMAN SACHS BANK USA",
//		"HORICON STATE BANK",
//		"HSBC BANK USA",
//		"ICE TRUST U.S. LLC",
//		"JPMORGAN CHASE BANK",
//		"KEYBANK NATIONAL ASSOCIATION",
//		"MORGAN STANLEY BANK",
//		"NATIONAL CITY BANK",
//		"NORTHERN TRUST COMPANY, THE",
//		"PARK AVENUE BANK, NATIONAL ASSOCIATION, THE",
//		"PNC BANK, NATIONAL ASSOCIATION",
//		"RBS CITIZENS, NATIONAL ASSOCIATION",
//		"SIGNATURE BANK",
//		"STATE STREET BANK AND TRUST COMPANY",
//		"SOUTHWEST BANK OF TEXAS, N.A.",
//		"SUNTRUST BANK",
//		"U.S. BANK NATIONAL ASSOCIATION",
//		"WACHOVIA BANK, NATIONAL ASSOCIATION",
//		"WELLS FARGO BANK, NATIONAL ASSOCIATION"
//				};
//
//		int [] cert = {101019,
//		917742,
//		101019,
//		480228,
//		541101,
//		968605,
//		497404,
//		837260,
//		476810,
//		3041974,
//		60143,
//		363415,
//		214807,
//		2182786,
//		528849,
//		413208,
//		3822016,
//		852218,
//		280110,
//		1456501,
//		259518,
//		210434,
//		1160152,
//		817824,
//		3303298,
//		2942690,
//		35301,
//		676656,
//		675332,
//		504713,
//		484422,
//		451965
//		};
//
//		
//		double [] B = {
//		0.005301099618,
//		0,
//		727.0633607,
//		0.8305056069,
//		0,
//		0,
//		0,
//		987.8040756,
//		0.000000706813282,
//		0.003727026438,
//		0.01970948838,
//		0.07068132825,
//		507.5011254,
//		0,
//		323.077173,
//		2361.831130,
//		3012.664390,
//		2.740173733,
//		15.59088738,
//		0.9084148078,
//		0.166454528,
//		6.288816756,
//		1.413979972,
//		0,
//		0.002120439847,
//		0.102487926,
//		0,
//		0.4136405623,
//		0.04488264344,
//		0,
//		0.7322585606
//				};
//
//		
//		double [] G = {
//		0.08345105644,
//		0.006917075423,
//		694.9835688,
//		0.001383415085,
//		0.03458537711,
//		0.03615762836,
//		0.0002566234982,
//		892.5171589,
//		0.006429421606,
//		0.03151281221,
//		0.02100369952,
//		0,
//		443.0123959,
//		0.004150245254,
//		327.6129784,
//		2361.831130,
//		2838.448876,
//		2.289069153,
//		0,
//		0.6524310046,
//		0,
//		0,
//		0.7294056033,
//		0.03837385932,
//		0,
//		0,
//		0.0001210488199,
//		0.1354494792,
//		0,
//		98.19411099,
//		0.3375532806
//				};
//
//		double [] CC = {
//		1.576864,
//		0.441536,
//		88.979017,
//		11.148,
//		0.695894,
//		6.157532,
//		0.872714,
//		70.977,
//		2.479166,
//		5.706736,
//		0.538101,
//		7.872,
//		13.212,
//		0.042265,
//		10.821919,
//		0.472366226,
//		100.597,
//		8.012102,
//		5.776,
//		12.757364,
//		4.385245,
//		0.019176,
//		8.337592,
//		8.471557,
//		0.760308,
//		13.422034,
//		0.939442,
//		12.564741,
//		14.558168,
//		32.772,
//		33.129
//				};
//
//
//		double [] MBS = {
//		4.075053,
//		0.66494,
//		212.678849,
//		28.257,
//		0.053103,
//		10.657331,
//		0.046527,
//		52.118,
//		6.706082,
//		7.860606,
//		1.428115,
//		0,
//		0,
//		0.001446,
//		20.977099,
//		0,
//		130.329,
//		8.090288,
//		0,
//		11.954815,
//		1.374393,
//		2.998115,
//		24.927323,
//		19.568868,
//		2.781575,
//		21.914959,
//		0.186711,
//		14.85349,
//		29.337319,
//		32.829,
//		60.149
//				           };
//		
//		double [] SPV = {
//		0.125075,
//		0,
//		0.158131,
//		0,
//		0,
//		0.002123,
//		0,
//		0.049,
//		0.004793,
//		0,
//		0,
//		0,
//		0,
//		0.001348,
//		0.00501,
//		0,
//		4.685,
//		0,
//		0,
//		0.708028,
//		0,
//		0,
//		0,
//		0.007252,
//		0,
//		0,
//		0,
//		0,
//		0.417267,
//		2.387,
//		0.588
//				         };
//		
//		double [] ReferenceEntityGross = {
//		0,	 //ASSOCIATED BANK
//		0,	//BANK LEUMI USA
//		51.947,	 //BoA
//		0,	 //Bank of New York Mellon
//		0,	 //Mitsubishi UFJ
//		0,	//BANKNORTH, NATIONAL ASSOCIATION
//		0,	//CALIFORNIA BANK & TRUST
//		66.637,	 //Citi
//		0,	//CITIZENS BANK OF PENNSYLVANIA
//		0,	 //Comerica
//		0,	 //Commerce
//		68.481,	 //Deutsche Bank Americas
//		94.039,	 //Goldman
//		0,	//Horicon
//		26.6,	 //HSBC USA
//		0,	//ICE
//		63.358,	 //JPMorgan
//		0,	 //Keybank
//		93.274,	 //Morgan Stanley
//		0,	 //National City
//		0,	 //Northern Trust
//		0,	 //PARK AVENUE BANK
//		0,	 //PNC
//		0,	 //RBS CITIZENS
//		0,	 //SIGNATURE BANK
//		0,	 //State Street and Trust
//		0,	 //SOUTHWEST
//		0,	 //SunTrust
//		0,	 //U.S. Bank
//		45.921,	 //Wachovia
//		46.177	 //Wells Fargo

//		         }; 
//		
//		double [] ReferenceEntityNet = {
//		0,	 //ASSOCIATED BANK
//		0,	//BANK LEUMI USA
//		3.964797707,	 //BoA
//		0,	 //Bank of New York Mellon
//		0,	//Mitsubishi UFJ
//		0,	//BANKNORTH, NATIONAL ASSOCIATION
//		0,	//CALIFORNIA BANK & TRUST
//		4.461130826,	 //Citi
//		0,	//CITIZENS BANK OF PENNSYLVANIA
//		0,	 //Comerica
//		0,	 //Commerce
//		8.608297866,	 //Deutsche Bank Americas
//		6.20342418,	 //Goldman
//		0,	//Horicon
//		2.085744164,	 //HSBC USA
//		0,	//ICE
//		4.45676969,	 //JPMorgan
//		0,	 //Keybank
//		4.45676969,	 //Morgan Stanley
//		0,	 //National City 
//		0,	 //Northern Trust
//		0,	 //PARK AVENUE BANK
//		0,	 //PNC
//		0,	 //RBS CITIZENS
//		0,	 //SIGNATURE BANK
//		0,	 //State Street and Trust
//		0,	 //SOUTHWEST
//		0,	 //SunTrust
//		0,	 //U.S. Bank
//		3.400942586,	 //Wachovia
//		3.441138055	 //Wells Fargo
//		         }; 
//		
		

		
		ArrayList<Bank> bankList = new ArrayList<Bank>();
		
		for(int i=0; i < B.length; i++)
		{
			
//			System.out.println("setValues" + i);
			
			bankList.add(new Bank(cert[i], 
					name[i],
					nameShort[i],
					B[i],
					G[i],
					CC[i],
					MBS[i],
					SPV[i],
					ReferenceEntityGross[i],
					ReferenceEntityNet[i]));
			
//		System.out.print((long)workBook.getNumber(i + 1, 3));
//		System.out.println(i + " -> " + (long)workBook.getNumber(i + 1, 5));
		}

		return bankList;
		
		
	}
	
	public static double getReferenceEntity_OE_Gross(){return 369.357;}
	public static double getReferenceEntity_OE_Net(){return 31.693;}

}
