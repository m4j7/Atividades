package br.com.agenda.Model;

public enum StAgendamento {

        pendente("Pendente"),
        aprovado("Aprovado"),
        cancelado("Cancelado"),
        compareceu("Compareceu"),
        ncompareceu("Não Compareceu"),
        rejeitado("Rejeitado");

        public final String valor;

        private StAgendamento(String valor) {
            this.valor = valor;
        }
    }

