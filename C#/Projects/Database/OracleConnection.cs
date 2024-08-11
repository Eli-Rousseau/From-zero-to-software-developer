using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Database
{
    internal class OracleConnection : DBConnection
    {
        public OracleConnection(string connectionString) : base(connectionString)
        {
        }

        public override void OpenConnection()
        {
            Console.WriteLine("Opens connection to Oracle database"); ;
        }

        public override void CloseConnection()
        {
            Console.WriteLine("Closes connection from Oracle database"); ;
        }
    }
}
