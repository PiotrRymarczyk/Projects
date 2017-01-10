#!/usr/bin/env python3

# Copyright 2014 Brett Slatkin, Pearson Education Inc.
#
# Udostępniono na licencji Apache w wersji 2.0 ("Licencja").
# Tego pliku można używać jedynie zgodnie z warunkami Licencji.
# Treść Licencji znajdziesz na stronie:
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# O ile obowiązujące prawo nie stanowi inaczej lub czegoś innego nie
# uzgodniono w formie pisemnej, oprogramowanie objęte Licencją jest
# dostarczane w stanie, w jakim jest (wersja "AS IS"), BEZ JAKIEJKOLWIEK
# GWARANCJI, ani wyrażonej otwarcie, ani domyślnej. Dokładne zasady
# i warunki Licencji znajdziesz w jej treści.

# Przygotowania mające na celu odtworzenie środowiska użytego w książce.
import logging
from pprint import pprint
from sys import stdout as STDOUT


# Przykład 1.
def to_str(data):
    if isinstance(data, str):
        return data
    elif isinstance(data, bytes):
        return data.decode('utf-8')
    else:
        raise TypeError('Oczekiwano ciągu tekstowego lub bajtów, '
                        'otrzymano: %r' % data)
