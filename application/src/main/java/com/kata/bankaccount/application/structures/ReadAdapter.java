package com.kata.bankaccount.application.structures;

import com.kata.bankaccount.common.structures.CommonDTO;
import com.kata.bankaccount.domain.structures.IReadPort;

public interface ReadAdapter<R extends IReadPort, DTO extends CommonDTO> {
    DTO adapt(R source);
}
