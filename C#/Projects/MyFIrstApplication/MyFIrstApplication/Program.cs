using MyFIrstApplication.Math;

namespace MyFIrstApplication
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var text = "This is just some test text to extract the kth word.";
            Console.WriteLine(text.KthWordInString(20));
        }
    }
}
