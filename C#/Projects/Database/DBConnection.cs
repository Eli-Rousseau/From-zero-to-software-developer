using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Database
{
    public abstract class DBConnection
    {
        private string _connectionString;
        private TimeSpan _timeOut;

        public DBConnection(string connectionString)
        {
            if (connectionString == null) throw new ArgumentNullException();
            _connectionString = connectionString;
        }

        public abstract void OpenConnection();
        public abstract void CloseConnection();
    }
}
