namespace MyFIrstApplication
{
    public static class StringExtensions
    {
        public static string KthWordInString(this string input, int k)
        {
            if (input == null) throw new ArgumentNullException();

            var words = input.Split(' ');

            if (k > words.Length) throw new ArgumentOutOfRangeException();

            return words[k - 1];
        }
    }
}
