import React from "react";

export default function LoanTable({ parcelas }) {
    if (!parcelas.length) return null;

    return (
        <div className="overflow-auto max-h-[500px] border rounded">
            <table className="min-w-full table-fixed">
                <thead className="bg-gray-200 sticky top-0 z-10">
                <tr>
                    <th className="border p-2">Data</th>
                    <th className="border p-2">Parcela</th>
                    <th className="border p-2">Juros</th>
                    <th className="border p-2">Amortização</th>
                    <th className="border p-2">Saldo</th>
                </tr>
                </thead>
                <tbody>
                {parcelas.map((p, i) => (
                    <tr key={i}>
                        <td className="border p-2">{p.data}</td>
                        <td className="border p-2">{p.parcela}</td>
                        <td className="border p-2">{p.juros}</td>
                        <td className="border p-2">{p.amortizacao}</td>
                        <td className="border p-2">{p.saldo}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}
