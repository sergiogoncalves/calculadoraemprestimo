const API_URL = process.env.REACT_APP_BACKEND_URL || "http://localhost:8080";

export async function calcularEmprestimo(dados) {
    const response = await fetch(`${API_URL}/api/emprestimos/calcular`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(dados),
    });

    if (!response.ok) throw new Error("Erro ao calcular empréstimo");

    return await response.json();
}
