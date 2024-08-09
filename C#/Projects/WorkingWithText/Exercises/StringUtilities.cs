using System;
using System.Collections.Generic;
using System.Diagnostics.Metrics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WorkingWithText.Exercises
{
    public class StringUtilities
    {
        internal static char[] vowels = new char[5] { 'a', 'e', 'i', 'o', 'u' };
        public static bool NumbersAreConsecutive(string inputString)
        {
            var splittedInputString = inputString.Split("-");

            var previousNumber = Convert.ToInt32(splittedInputString[0]);
            for (var i = 1; i < splittedInputString.Length; i++)
            {
                if (Convert.ToInt32(splittedInputString[i]) - 1 != previousNumber)
                    return false;
                previousNumber = Convert.ToInt32(splittedInputString[i]);
            }
            return true;
        }

        public static int CountVowels(string inputString)
        {
            var vowelsCount = 0;
            for (var i = 0; i < inputString.Length; i++)
            {
                if (vowels.Contains(inputString[i]))
                    vowelsCount++;
            }
            return vowelsCount;
        }
    }
}
