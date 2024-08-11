using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Stack
{
    internal class Stack
    {
        private readonly ArrayList _stack;

        public Stack()
        {
            _stack = new ArrayList();
        }

        public void Push(object obj)
        {
            if (obj == null) throw new InvalidOperationException();

            _stack.Add(obj);
        }

        public object Pop()
        {
            if (_stack.Count == 0) throw new InvalidOperationException();

            object lastObject = _stack[_stack.Count - 1];
            _stack.RemoveAt(_stack.Count - 1);
            return lastObject;
        }

        public void Clear()
        {
            while (_stack.Count > 0) this.Pop();
        }
    }
}
