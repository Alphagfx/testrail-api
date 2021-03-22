package com.alphagfx.testrail;

interface Plans {

	Plan create(/* todo verify number of required parameters */);

	Plan get(int id);

	Iterable<Plan> list();     //todo how to use internal filters?
}
