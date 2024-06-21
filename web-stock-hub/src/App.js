import './App.css';
import {useEffect, useState} from "react";

function App() {
    const [vehicles, setVehicles] = useState([]);

    useEffect(() => {
        const fetchCars = async () => {
            try {
                const loginResponse = await fetch('http://localhost:8080/login', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({ username: "integracaoapi@autonitro.com.br", password: "integracaoapi@autonitro.com.br" })
                });
                const response = await fetch('http://localhost:8080/stock/all');
                const data = await response.json();
                setVehicles(data);
            } catch (error) {
                console.error('Erro ao buscar os carros:', error);
            }
        };

        fetchCars();
    }, []);

    return (
        <div className="app">
            <div>{vehicles[0].Marca}</div>
        </div>
    );
}

export default App;
