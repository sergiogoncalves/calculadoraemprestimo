import React from "react";

export default function LoanForm({ form, onChange, onSubmit, isValid }) {
    return (
        <div className="grid grid-cols-1 md:grid-cols-3 gap-4 mb-4">
            {[
                { name: "dataInicial", label: "Data Inicial", type: "date" },
                { name: "dataFinal", label: "Data Final", type: "date" },
                { name: "primeiroPagamento", label: "1º Pagamento", type: "date" },
                { name: "valorEmprestimo", label: "Valor do Empréstimo", type: "number" },
                { name: "taxaJuros", label: "Taxa de Juros (%)", type: "number", step: "0.01" },
            ].map(({ name, label, type, step }) => (
                <div key={name} className="flex flex-col">
                    <label htmlFor={name} className="mb-1 text-sm font-medium text-gray-700">{label}</label>
                    <input
                        name={name}
                        id={name}
                        type={type}
                        step={step}
                        value={form[name]}
                        onChange={onChange}
                        className="border p-2 rounded"
                    />
                </div>
            ))}
            <div className="col-span-full">
                <button
                    onClick={onSubmit}
                    disabled={!isValid}
                    className="bg-blue-600 text-white px-4 py-2 rounded disabled:opacity-50"
                >
                    Calcular
                </button>
            </div>
        </div>
    );
}
