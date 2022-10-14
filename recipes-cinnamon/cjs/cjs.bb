SUMMARY = "TThe Cinnamon Javascript interpreter"
LICENSE = "GPL-2.0-only & LGPL-2.0-only"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=beb29cf17fabe736f0639b09ee6e76fa \
    file://COPYING.LGPL;md5=3bf50002aefd002f49e7bb854063f7e7 \
"

DEPENDS = " \
    dbus-native \
    glib-2.0-native \
    gtk+3 \
    mozjs-91 \
    sysprof \
"

inherit meson pkgconfig gobject-introspection features_check gettext

REQUIRED_DISTRO_FEATURES = "x11 gobject-introspection-data"
GIR_MESON_OPTION = ""

SRC_URI = "git://github.com/linuxmint/cjs.git;branch=master;protocol=https"
SRCREV = "7235a06fe12bff39c8ab15788fe8c8618a45f163"
PV = "5.4.1+"
S = "${WORKDIR}/git"

EXTRA_OEMESON += " \
    -Dinstalled_tests=false \
    -Dskip_dbus_tests=true \
    -Dskip_gtk_tests=true \
"

do_configure:prepend() {
    sed -i 's:gidatadir =.*:gidatadir = '"'"'${STAGING_DATADIR_NATIVE}/gobject-introspection-1.0'"'"':g' ${S}/installed-tests/js/meson.build
}

FILES:${PN} += "${datadir}/cjs-1.0"
