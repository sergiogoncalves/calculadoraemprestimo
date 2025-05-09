import React, { useState } from "react";
import LoanForm from "./components/LoanForm";
import LoanTable from "./components/LoanTable";
import { calcularEmprestimo } from "./services/emprestimoService";

function App() {
  const [form, setForm] = useState({
    dataInicial: "",
    dataFinal: "",
    primeiroPagamento: "",
    valorEmprestimo: "",
    taxaJuros: "",
  });
  const [parcelas, setParcelas] = useState([]);

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const calcular = async () => {
    try {
      const data = await calcularEmprestimo(form);
      setParcelas(data);
    } catch (error) {
      console.error("Erro:", error);
      alert("Ocorreu um erro ao calcular o empréstimo.");
    }
  };

  const isValid = Object.values(form).every(Boolean);

  return (
      <div className="min-h-screen w-full p-8 bg-gray-50">
        <h1 className="text-2xl font-bold mb-6">Calculadora de Empréstimos</h1>
        <LoanForm form={form} onChange={handleChange} onSubmit={calcular} isValid={isValid} />
        <LoanTable parcelas={parcelas} />
      </div>
  );
}

export default App;
