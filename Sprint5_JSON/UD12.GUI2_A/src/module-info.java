/**
 * 
 * @author usuario
 *
 */
module UD12.GUI {
	requires java.desktop;
	requires java.sql;
	requires org.xerial.sqlitejdbc;
	requires com.google.gson;
	opens modelo to com.google.gson;
}