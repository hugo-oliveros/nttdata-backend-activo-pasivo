package com.nttdata.incloud.service;

import com.nttdata.incloud.commons.GenericServiceAPI;
import com.nttdata.incloud.model.Cliente;

public interface SequenceService extends GenericServiceAPI<Cliente, Long> {

	public long generateSequence(String seqName);
}
