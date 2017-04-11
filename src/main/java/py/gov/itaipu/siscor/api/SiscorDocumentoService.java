package py.gov.itaipu.siscor.api;

import java.util.List;

import com.atlassian.activeobjects.tx.Transactional;


@Transactional
public interface SiscorDocumentoService<T>
{
    T add(T documento);

    List<T> all();

    T last();

}
