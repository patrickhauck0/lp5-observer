package org.example.observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {
    @Test
    void deveNotificarUmUsuario() {
        Assinatura assinatura = new Assinatura("HTML", "https://example.com/html");
        Usuario usuario = new Usuario("patrickhauck@gmail.com");
        usuario.assinar(assinatura);
        assinatura.lancarNotificao();
        assertEquals("patrickhauck@gmail.com, Obrigado por se inscrever{no curso de='HTML', link para download dos materiais='https://example.com/html'}", usuario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarUsuarios() {
        Assinatura assinatura = new Assinatura("HTML", "https://example.com/html");
        Usuario usuario1 = new Usuario("phds@gmail.com");
        Usuario usuario2 = new Usuario("ninjafu40@gmail.com");
        usuario1.assinar(assinatura);
        usuario2.assinar(assinatura);
        assinatura.lancarNotificao();
        assertEquals("phds@gmail.com, Obrigado por se inscrever{no curso de='HTML', link para download dos materiais='https://example.com/html'}", usuario1.getUltimaNotificacao());
        assertEquals("ninjafu40@gmail.com, Obrigado por se inscrever{no curso de='HTML', link para download dos materiais='https://example.com/html'}", usuario2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarUsuario() {
        Assinatura assinatura = new Assinatura("HTML", "https://example.com/html");
        Usuario usuario = new Usuario("thalesalv@gmail.com");
        assinatura.lancarNotificao();
        assertEquals(null, usuario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarUsuarioPowerBI() {
        Assinatura assinaturaPowerBI = new Assinatura("PowerBI", "https://example.com/powerbi");
        Assinatura assinaturaCss = new Assinatura("Css", "https://example.com/css");
        Usuario usuario1 = new Usuario("phds@gmail.com");
        Usuario usuario2 = new Usuario("ninjafu40@gmail.com");
        usuario1.assinar(assinaturaPowerBI);
        usuario2.assinar(assinaturaCss);
        assinaturaPowerBI.lancarNotificao();
        assertEquals("phds@gmail.com, Obrigado por se inscrever{no curso de='PowerBI', link para download dos materiais='https://example.com/powerbi'}", usuario1.getUltimaNotificacao());
        assertEquals(null, usuario2.getUltimaNotificacao());
    }
}