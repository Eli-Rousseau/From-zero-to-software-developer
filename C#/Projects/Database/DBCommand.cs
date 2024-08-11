using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Database
{
    public class DBCommand
    {
        private DBConnection _connection;
        private string _instruction;

        public DBCommand(DBConnection connection, string instruction)
        {
            if (connection == null) throw new ArgumentNullException();
            _connection = connection;

            if (string.IsNullOrWhiteSpace(instruction)) throw new ArgumentNullException();
            _instruction = instruction;
        }

        public void excute()
        {
            _connection.OpenConnection();
            runInstruction();
            _connection.CloseConnection();
        }

        private void runInstruction()
        {
            Console.WriteLine("Execute {0}", _instruction);
        }
    }
}
