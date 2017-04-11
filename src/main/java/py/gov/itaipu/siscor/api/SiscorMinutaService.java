package py.gov.itaipu.siscor.api;

import com.atlassian.activeobjects.tx.Transactional;
import java.util.List;

import py.gov.itaipu.siscor.entity.confluence.SiscorMinuta;
import py.gov.itaipu.siscor.entity.confluence.dto.SiscorMinutaDTO;


@Transactional
public interface SiscorMinutaService
{
    SiscorMinuta addMinuta(SiscorMinutaDTO siscorMinutaDTO);

    List<SiscorMinuta> allMinuta();

    SiscorMinuta lastMinuta();

}
