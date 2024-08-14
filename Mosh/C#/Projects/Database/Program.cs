namespace Database
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var connectionString = "This is my connection string";
            DBConnection sqlConnection = new SqlConnection(connectionString);
            DBConnection oracleConnection = new OracleConnection(connectionString);

            var command1 = new DBCommand(sqlConnection, "Copy row");
            command1.excute();

            var command2 = new DBCommand(oracleConnection, "Create column");
            command2.excute();
        }
    }
}
