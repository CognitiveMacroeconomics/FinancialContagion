import java.sql.*;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;


public final class BasisTradeDataController {
	
	private static String FDICdatabaseName = "Ali"; 
	
	
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Utility Methods>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	private static Connection getConnection(String databasebName) throws SQLException {
		/**
		 * This method established a connection to the database.
		 */
		String connectionUrl = null;
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connectionUrl = "jdbc:mysql://localhost:3306/" + databasebName + "?user=root";//generic URL to connect to a database
			connection = (Connection) DriverManager.getConnection(connectionUrl); //establish connection
			System.out.println("Database connection established");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}//end of getConnection method
	
	
	public static final double getCDSRisValue(String IDRSSD, String periodEndDate, String risName) {

		double value=0;

		try {
			StringBuffer query = new StringBuffer();
			query.append("SELECT FRB_CODE");
			query.append(" FROM ");
			query.append("cds_glossary");
			query.append(" WHERE RIS__NAME =\"" + risName );
			query.append("\"");
			//	  query.append("ORDER BY index_rank ");
			//			query.append("ORDER BY Financial_Institution_Name ");
			//System.out.println(query.toString());
			Connection connection = getConnection(FDICdatabaseName);
			Statement statement = connection.createStatement();
			// System.out.println("query=" + query);
			ResultSet resultSet = statement.executeQuery(query.toString());
			resultSet.next();
			String result=resultSet.getString("FRB_CODE");

			String[] results=result.split("_");
			//System.out.println(results[3]);

			//check check /2********************
			int length=0;
			int i = 0;
			int k;
			if (risName.compareTo("SCMTGBK")==1 && (periodEndDate.compareTo("q1_09")==1) || 
					(periodEndDate.compareTo("q2_09")==1) || (periodEndDate.compareTo("q3_09")==1)){
				k=12;
				length=results.length;
			}
			else{
				k=0;
				if (risName.compareTo("SCMTGBK")==1){
					length=results.length/2;
					}
				else 
					length=results.length;
			}


			i+=k;
			while( i < length){
			//for (int i=0+k;i<length;i++){
				//if (getValue(IDRSSD,periodEndDate,results[i]).length()!=0){
				if ((getValue(IDRSSD,periodEndDate,results[i])!=null)
						&&
						(getValue(IDRSSD,periodEndDate,results[i]).length()!=0)){
					//System.out.println(results[i]);
					value += Double.parseDouble(getValue(IDRSSD,periodEndDate,results[i]));
				}
				//System.out.println(i);
				//System.out.println(value);
				i++;
			}
			//System.out.println(value);


			//value = resultSet.getString(field);
			//	System.out.println(resultSet.getString(field));

			resultSet.close();
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		//return null;
		return value;
	}




	public static final String getValue(String IDRSSD, String periodEndDate, String field) {

		String tableName=getDatabaseTableName(periodEndDate, field);


		String value = null;
		try {
			StringBuffer query = new StringBuffer();
			query.append("SELECT " + field);
			query.append(" FROM ");
			query.append(tableName);
			query.append(" WHERE IDRSSD =" + IDRSSD );
			//	  query.append("ORDER BY index_rank ");
			//			query.append("ORDER BY Financial_Institution_Name ");

			Connection connection = getConnection(FDICdatabaseName);
			Statement statement = connection.createStatement();
			// System.out.println("query=" + query);
			ResultSet resultSet = statement.executeQuery(query.toString());

			resultSet.next();
			value = resultSet.getString(field);
			//System.out.println(resultSet.getString(field));

			resultSet.close();
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return value;
	}

	// function will search for table name according to quarter year and field name
	public static final String getDatabaseTableName(String quarterYear,String field){
//		Ali's original code
//		String tableNames[]={"p1_rcr","p2_rcr", "rc", "rcl","rcb","rcs", "rcp"};
//		String tableNames2[]={"p1_rcr","p2_rcr", "rc", "rcl","p1_rcb","p2_rcb","rcs", "rcp"};
		String tableNames[]={"p1_rcr","p2_rcr", "rc", "rcl","rcb","rcs"};
		String tableNames2[]={"p1_rcr","p2_rcr", "rc", "rcl","p1_rcb","p2_rcb","rcs"};
		String value = null;
		if (quarterYear=="q3_09_"){
			tableNames=tableNames2;

		}
//		Ali's original code
//		for (int i=0;i<7;i++){
		for (int i=0;i<6;i++){



			try {
				StringBuffer query = new StringBuffer();
				query.append(" SHOW columnS From ");
				query.append(quarterYear);
				query.append(tableNames[i]);

				//System.out.println(query);

				Connection connection = getConnection(FDICdatabaseName);
				Statement statement = connection.createStatement();
				// System.out.println("query=" + query);
				ResultSet resultSet = statement.executeQuery(query.toString());



				//tableName1
				while (resultSet.next()){
					value = resultSet.getString("Field");
					if (value.compareTo(field)==0)
					{//System.out.println( tableNames[i]);
						return quarterYear+tableNames[i];
					}
					//System.out.println(value.toString());

				} 

			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}


	
	
	

}//end of BasisTradeDataController class definition
