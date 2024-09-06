// Define the props interface
interface MyComponentProps {
    title: string;
    count: number;
  }
  
  function MyComponent({ title, count }: MyComponentProps) {
    return (
      <div>
        <h1>{title}</h1>
        <p>Count: {count}</p>
      </div>
    );
  };
  
  export default MyComponent;