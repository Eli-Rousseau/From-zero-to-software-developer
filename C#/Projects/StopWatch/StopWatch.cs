using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace StopWatch
{
    internal class StopWatch
    {
        private bool _isRunning;
        private DateTime _lastStartTime;
        private TimeSpan _totalTime;

        public StopWatch()
        {
            _isRunning = false;
            _totalTime = new TimeSpan(0, 0, 0);
        }

        public void Start()
        {
            if (_isRunning) throw new InvalidOperationException();

            _lastStartTime = DateTime.Now;
            _isRunning = true;
        }

        public void Stop()
        {
            if (!_isRunning) throw new InvalidOperationException();

            var lastStopTime = DateTime.Now;
            var timeDifference = lastStopTime - _lastStartTime;
            _totalTime += timeDifference;
            Console.WriteLine(_totalTime.ToString("c"));

            _isRunning = false;
        }

        public void Reset()
        {
            if (_isRunning) throw new InvalidOperationException();

            _totalTime = new TimeSpan(0 ,0, 0);
        }


    }
}
