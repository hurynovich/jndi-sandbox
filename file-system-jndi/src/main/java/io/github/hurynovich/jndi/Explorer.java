package io.github.hurynovich.jndi;

import javax.naming.*;
import java.util.Hashtable;

public class Explorer {
    private final Context ctx;

    public Explorer() throws NamingException {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
        ctx = new InitialContext(env);
    }

    public Object root() throws NamingException {
        return ctx.lookup("/");
    }

    public void list() throws NamingException {
        NamingEnumeration<NameClassPair> names = ctx.list("Lotus/Notes");
        while (names.hasMore()){
            NameClassPair n = names.next();
            System.out.println("" + n.getName() + "(" + n.getClassName() + ")");
        }

    }

    public static void main(String[] args) throws NamingException {
        Explorer exp = new Explorer();
        exp.list();
    }
}
