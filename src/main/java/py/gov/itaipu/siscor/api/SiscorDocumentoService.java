package py.gov.itaipu.siscor.api;

import java.util.List;

import com.atlassian.activeobjects.tx.Transactional;

import net.java.ao.Entity;
import py.gov.itaipu.siscor.entity.confluence.SiscorDocumento;
import py.gov.itaipu.siscor.entity.confluence.dto.SiscorDocumentoDTO;


@Transactional
public interface SiscorDocumentoService<T extends SiscorDocumento & Entity, G extends SiscorDocumentoDTO>
{
    T add(G documentoDTO);

    List<T> all();

    T last();

}
