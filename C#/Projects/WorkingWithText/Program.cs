using WorkingWithText.Exercises;

namespace WorkingWithText
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Enter a serie of consecutive numbers seperated by hyphens (-):");
            string inputString = Console.ReadLine();
            if (StringUtilities.NumbersAreConsecutive(inputString))
                Console.WriteLine("Consecutive");
            else
                Console.WriteLine("Not Consecutive");

            Console.Write("Enter a word for which you want to count the vowels: ");
            inputString = Console.ReadLine();
            var numberOfVowels = StringUtilities.CountVowels(inputString);
            if (numberOfVowels == 0)
                Console.WriteLine("There are no vowels in the input word.");
            else
                Console.WriteLine("The word contains " + numberOfVowels + " vowels.");
        }
    }
}
