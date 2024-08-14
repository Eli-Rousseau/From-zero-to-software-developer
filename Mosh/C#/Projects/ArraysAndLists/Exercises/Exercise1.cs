using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ArraysAndLists.Exercises
{
    internal class Exercise1
    {
        public static void Program()
        {
            var allFriendNames = new List<string>();
            string friendName;

            while (true)
            {
                Console.Write("Enter name of a person that liked your post: ");
                friendName = Console.ReadLine();
                if (String.IsNullOrEmpty(friendName))
                    break;
                allFriendNames.Add(friendName);
            }

            if (allFriendNames.Count == 1)
                Console.WriteLine(String.Format("{0} likes your post.", 
                    allFriendNames.ElementAt(0)));
            else if (allFriendNames.Count > 1)
                Console.WriteLine(String.Format("{0} and {1} like your post.",
                    String.Join(", ", allFriendNames.GetRange(0, allFriendNames.Count - 1)),
                    allFriendNames.ElementAt(allFriendNames.Count - 1)));

        }
    }
}
