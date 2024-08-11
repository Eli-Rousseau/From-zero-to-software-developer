namespace StackOverFlow
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var post = new Post("First Post", "This is some text for the first post.");
            post.DownVote();
            post.UpVote();
            post.DownVote();
            Console.WriteLine("Your post has been voted {0} times.", post.NumberOfVotes);
        }
    }
}
