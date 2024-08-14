using System.Text.RegularExpressions;

namespace WorkingWithFiles
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var filePath = @"D:\From zero to software developer\C#\C#.md";

            var fileContent = File.ReadAllText(filePath);

            var fileWords = Regex.Split(fileContent, @"\s+");
            Console.WriteLine("The number of words in the file are: " + fileWords.Length);
        }
    }
}
