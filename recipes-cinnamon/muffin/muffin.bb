SUMMARY = "The window management library for the Cinnamon desktop"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=8955bdc698cdc995fb6abba2cb6f7347"

DEPENDS = " \
    glib-2.0-native \
    intltool-native \
    gdk-pixbuf-native \
    gnome-doc-utils-stub \
    gtk+3 \
    json-glib \
    libinput \
    cinnamon-desktop \
"

inherit autotools features_check gettext gtk-doc gobject-introspection gsettings

REQUIRED_DISTRO_FEATURES = "x11"

SRC_URI = " \
    git://github.com/linuxmint/muffin.git;branch=master;protocol=https \
    file://0001-Do-not-check-fo-zenity-executable.patch \
    file://gtk-doc.make \
"
SRCREV = "6a2a5a65f6dad71c37fdea34dad80035bd4ca336"
PV = "5.2.0"
S = "${WORKDIR}/git"

EXTRA_OECONF = "--disable-gtk-doc"

do_configure:prepend() {
    cp ${WORKDIR}/gtk-doc.make ${S}/
}

MUFFIN_API_NAME = "muffin"

do_install:append() {
    # Add gir links in standard paths. That makes dependents life much easier
    # to find them
    install -d ${D}${datadir}/gir-1.0
    for gir_full in `find ${D}${libdir}/${MUFFIN_API_NAME} -name '*.gir'`; do
        gir=`basename "$gir_full"`
        ln -sr "${D}${libdir}/${MUFFIN_API_NAME}/$gir" "${D}${datadir}/gir-1.0/$gir"
    done

    # same for typelibs
    install -d ${D}${libdir}/girepository-1.0
    for typelib_full in `find ${D}${libdir}/${MUFFIN_API_NAME} -name '*.typelib'`; do
        typelib=`basename "$typelib_full"`
        ln -sr "${D}${libdir}/${MUFFIN_API_NAME}/$typelib" "${D}${libdir}/girepository-1.0/$typelib"
    done
}

export GIR_EXTRA_LIBS_PATH="${B}/cogl/cogl/.libs:${B}/cogl/cogl-pango/.libs:${B}/cogl/cogl-path/.libs:${B}/clutter/clutter/.libs"

FILES:${PN} += " \
    ${datadir}/glib-2.0/schemas \
"

RDEPENDS_${PN} += "zenity"
