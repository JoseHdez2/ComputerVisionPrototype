
cd ../src/i18n

# Load file, sort each line of the file and save the file.
sort_and_save() {
	cat $1 | sort > $1
}

sort_and_save i18nBundle_en.properties
sort_and_save i18nBundle_es.properties

# TODO: script creates i18nBundle_empty.properties that has all combined keys from real bundles.
# then compares itself with each 'real' bundle and makes sure none is missing any key.

# TODO: script that scans all code and bundles and does a search and replace.
# in case we want to more easily change the name of a bundle key
