package com.example.alugafacil.alugafacil.services;

import com.example.alugafacil.alugafacil.models.Imovel;
import com.example.alugafacil.alugafacil.repositories.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private ImovelRepository imovelRepository;

    public void instanciaDB(){
        Imovel imovel1 = new Imovel(
                null,
                "Apartamento de alto padrão, 3 quartos (1 suíte), varanda gourmet, vista mar. Condomínio com piscina, academia e segurança 24h. Ideal para família ou executivos.",
                "Rua Barão de Souza Leão, 451, Apto 1202 - Boa Viagem, Recife - PE"
        );
        Imovel imovel2 = new Imovel(
                null, // id = null
                "Casa térrea espaçosa, 4 quartos, jardim amplo, piscina privativa. Localizada em rua tranquila e arborizada no coração de Casa Forte. Perfeita para quem busca conforto e privacidade.", // Descrição (185 caracteres)
                "Rua Engenheiro Antônio de Carvalho, 32, Casa A - Casa Forte, Recife - PE"
        );

        Imovel imovel3 = new Imovel(
                null, // id = null
                "Flat mobiliado, pronto para morar, com serviços inclusos (limpeza, internet). Próximo a faculdades e centros empresariais. Ótima opção para estudantes ou aluguel de curta temporada.", // Descrição (174 caracteres)
                "Avenida Guararapes, 150, Flat 805 - Santo Antônio, Recife - PE"
        );

        Imovel imovel4 = new Imovel(
                null, // id = null
                "Ponto comercial estratégico no bairro do Pina, com 60m² e banheiro social. Ideal para escritórios, clínicas ou pequenos varejos. Alto fluxo de veículos e pedestres. Próximo à Av. Conselheiro Aguiar.", // Descrição (200 caracteres)
                "Rua Capitão Zuzinha, 180, Loja 01 - Pina, Recife - PE"
        );

        Imovel imovel5 = new Imovel(
                null, // id = null
                "Apartamento simples e funcional, 2 quartos, área de serviço, condomínio fechado. Excelente custo-benefício. Próximo ao Hospital Getúlio Vargas e à BR-101. Ideal para o primeiro aluguel.", // Descrição (179 caracteres)
                "Rua João Ivo da Silva, 400, Bloco C, Apto 301 - Cordeiro, Recife - PE"
        );

        imovelRepository.saveAll(Arrays.asList(imovel1, imovel2, imovel3, imovel4, imovel5));
    }
}
