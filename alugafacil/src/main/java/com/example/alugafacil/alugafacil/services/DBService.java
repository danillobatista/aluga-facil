package com.example.alugafacil.alugafacil.services;

import com.example.alugafacil.alugafacil.models.Aluguel;
import com.example.alugafacil.alugafacil.models.Imovel;
import com.example.alugafacil.alugafacil.models.Inquilino;
import com.example.alugafacil.alugafacil.repositories.AluguelRepository;
import com.example.alugafacil.alugafacil.repositories.ImovelRepository;
import com.example.alugafacil.alugafacil.repositories.InquilinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private ImovelRepository imovelRepository;

    @Autowired
    private InquilinoRepository inquilinoRepository;

    @Autowired
    private AluguelRepository aluguelRepository;

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

        // Inquilino 1: Nome Composto Comum
        Inquilino inquilino1 = new Inquilino(
                null, // id = null
                "Ana Paula Souza",
                "anapaula.souza@emailficticio.com.br"
        );

        Inquilino inquilino2 = new Inquilino(
                null, // id = null
                "João Silva",
                "joao.silva@servidor.com"
        );

        Inquilino inquilino3 = new Inquilino(
                null, // id = null
                "Camila Oliveira Santos",
                "camilasoliveira@provedor.com.br"
        );

        Inquilino inquilino4 = new Inquilino(
                null, // id = null
                "Carlos Alberto Pereira",
                "calberto.pereira@empresa.com"
        );

        Inquilino inquilino5 = new Inquilino(
                null, // id = null
                "Mariana Gomes",
                "mgomes92@mailteste.net"
        );

        Inquilino inquilino6 = new Inquilino(
                null, // id = null
                "Lucas Mendes",
                "lucas.mendes.aluga@gmail.com"
        );

        inquilinoRepository.saveAll(Arrays.asList(inquilino1,inquilino2,inquilino3,inquilino4,inquilino5,inquilino6));

        // Aluguel 1
        Aluguel aluguel1 = new Aluguel(
                        null, // id = null
                inquilino1,
                imovel1,
                        LocalDate.parse("2025-10-01"),
                        1500.00
                );

        // Aluguel 2
        Aluguel aluguel2 = new Aluguel(
                        null, // id = null
                inquilino2,
                imovel2,
                        LocalDate.parse("2025-10-05"),
                        2000.00
                );

        // Aluguel 3
        Aluguel aluguel3 = new Aluguel(
                        null, // id = null
                inquilino3,
                imovel3,
                        LocalDate.parse("2025-10-10"),
                        1200.00
                );

        // Aluguel 4
        Aluguel aluguel4 = new Aluguel(
                        null, // id = null
                inquilino4,
                imovel4,
                        LocalDate.parse("2025-10-05"),
                        1800.00
                );

        // Aluguel 5
        Aluguel aluguel5 = new Aluguel(
                        null, // id = null
                inquilino5,
                imovel5,
                        LocalDate.parse("2025-10-20"),
                        1000.00
                );

        // Aluguel 6
        Aluguel aluguel6 = new Aluguel(
                        null, // id = null
                inquilino6,
                imovel1,
                        LocalDate.parse("2025-09-30"),
                        1500.00
                );

        aluguelRepository.saveAll(Arrays.asList(aluguel1, aluguel2, aluguel3, aluguel4, aluguel5, aluguel6));
    }
}
