namespace StopWatch
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var watch = new StopWatch();
            watch.Start();
            Thread.Sleep(10000);
            watch.Stop();

            watch.Start();
            Thread.Sleep(5000);
            watch.Stop();

            watch.Reset();
            watch.Start();
            Thread.Sleep(7000);
            watch.Stop();

        }
    }
}
