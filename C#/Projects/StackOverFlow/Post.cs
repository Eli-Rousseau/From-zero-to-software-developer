using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace StackOverFlow
{
    internal class Post
    {
        private string _postTitle;
        private string _postDescription;
        private int _numberOfVotes;

        public int NumberOfVotes 
        {
            get { return _numberOfVotes; }
            private set { _numberOfVotes = value; } 
        }
        
        public Post(string postTitle, string postDescription)
        {
            this._postTitle = postTitle;
            this._postDescription = postDescription;
        }

        public void UpVote() 
        {
            NumberOfVotes = ++_numberOfVotes;
        }

        public void DownVote()
        {
            NumberOfVotes = --_numberOfVotes;
        }
    }
}
