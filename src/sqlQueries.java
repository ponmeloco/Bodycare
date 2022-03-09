import java.sql.*;

public class sqlQueries {

    private void connection(String string, Connection con) throws SQLException {

        Statement state = con.createStatement();
        state.execute(string);
    }

    public void createUserTable(Connection con) throws SQLException {

        String string = "create table user ("+
                        "ID integer primary key autoincrement ,"+
                        "Username varchar(255) not null ,"+
                        "Password varchar(255) not null"+
                        ");";
        connection(string, con);
    }

    public void createKundenTable(Connection con) throws SQLException {

        String string = "create table kunden("+
                        "ID integer primary key autoincrement,"+
                        "firstName varchar(255) not null,"+
                        "lastName varchar(255) not null,"+
                        "email varchar(255),"+
                        "mobilnummer varchar(255),"+
                        "strasse varchar(255),"+
                        "postleitzahl varchar(255),"+
                        "stadt varchar(255)"+
                        ");";
        connection(string, con);
    }

    public void createKundenUmsatzTable(Connection con) throws SQLException {

        String string = "create table kundenUmsatz("+
                        "ID integer primary key autoincrement,"+
                        "kundenID int not null,"+
                        "behandlungID int not null,"+
                        "extraAusgaben int,"+
                        "datum date not null,"+
                        "notiz varchar(255),"+
                        "bonusEingeloest int,"+
                        "constraint fk_bonusEingeloest foreign key(bonusEingeloest) references bonus(ID),"+
                        "constraint fk_kundenID foreign key (kundenID) references kunden(ID),"+
                        "constraint fk_behandlungID foreign key (behandlungID) references produkt(ID)"+
                        ");";
        connection(string, con);
    }

    public void createProdukt(Connection con) throws SQLException {

        String string = "create table produkt (\n" +
                        "ID integer primary key autoincrement," +
                        "behandlung varchar(255) not null," +
                        "kosten varchar(255) not null" +
                        ");";
        connection(string, con);
    }

    public void createBonus(Connection con) throws SQLException {

        String string = "create table bonus (" +
                        "ID integer primary key autoincrement ," +
                        "prozent int" +
                        ");";
        connection(string, con);
    }

    public void insertUser(String name, String password, Connection con) throws SQLException {

        String string = "INSERT INTO main.user (Username, Password) VALUES ('"+ name +"','"+ password +"');";
        connection(string,con);

    }
}




