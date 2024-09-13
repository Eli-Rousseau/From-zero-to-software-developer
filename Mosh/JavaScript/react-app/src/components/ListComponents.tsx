import axios, { AxiosResponse, AxiosError } from 'axios';

// Define an interface for the data being sent to the server
interface NewItem {
  name: string;
}

// Define an interface for the response data
interface Item {
  id: number;
  name: string;
}

// Send a POST request to create a new item
axios.post<Item>('https://api.example.com/items', { name: 'New Item' })
  .then(response => {
    // Log the response data if the request is successful
    console.log('Item created:', response.data);
  })
  .catch(error => {
    // Log the error message if the request fails
    console.error('Error creating item:', error.message);
  });
