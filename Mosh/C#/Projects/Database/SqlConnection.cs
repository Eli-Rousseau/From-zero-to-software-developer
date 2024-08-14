using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Database
{
    public class SqlConnection : DBConnection
    {
        public SqlConnection(string connectionString) : base(connectionString)
        {
        }

        public override void OpenConnection()
        {
            Console.WriteLine("Opens connection to Sql database");
        }
        public override void CloseConnection()
        {
            Console.WriteLine("Closes connection of Sql database");
        }
    }
}
