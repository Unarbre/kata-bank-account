package com.kata.bankaccount.exposition.structure;

import com.kata.bankaccount.common.structures.CommonDTO;

public interface IExpositionAdapter<From extends CommonDTO, To extends ExpositionDTO> {
    To adapt(From source);
}
