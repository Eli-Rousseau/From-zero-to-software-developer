import axios from "axios";
import { useEffect, useState } from "react";

interface List {
    userId: number,
    id: number,
    title: string,
    body: string
}

function ListComponents() {
    const [list, setList] = useState<List[]>([]);
    const [error, setError] = useState<string>('');
    const [isLoading, setIsLoading] = useState<boolean>(false);

    useEffect(() => {
        const controller = new AbortController();

        axios
    })
}

export default ListComponents;