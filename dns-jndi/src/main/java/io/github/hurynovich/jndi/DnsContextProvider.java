package io.github.hurynovich.jndi;

import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;

public class DnsContextProvider {

    public DirContext provideContext(){
        Hashtable<String,String> env=new Hashtable<String,String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.dns.DnsContextFactory");
        env.put(Context.PROVIDER_URL,"dns:4.2.2.3");
        try {
            return new InitialDirContext(env);
        } catch (Exception e) {
            throw new RuntimeException("Cannot create InitialDirContext for DNS lookup", e);
        }
    }
}
