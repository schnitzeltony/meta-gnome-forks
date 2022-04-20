SUMMARY = "Cross-desktop libraries and common resources"
LICENSE = "GPL-3.0-only & LGPL-3.0-only"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=97ff9683aa36f333c7d2295d6520090f \
    file://COPYING.LESSER;md5=e6a600fd5e1d9cbde2d983680233ad02 \
"

DEPENDS = " \
    python3-pygobject \
    gtk+3 \
    libgnomekbd \
"


# gobject-introspection is mandatory and cannot be configured
GIR_MESON_OPTION = ""
REQUIRED_DISTRO_FEATURES += "gobject-introspection-data"

ANY_OF_DISTRO_FEATURES = "${GTK3DISTROFEATURES}"

inherit meson pkgconfig gobject-introspection gtk-icon-cache gsettings gettext vala gtk-doc features_check  

SRC_URI = "git://github.com/linuxmint/xapp.git;branch=master;protocol=https"
SRCREV = "f62739e4f341ef831387e72af36b62fff8268f77"
PV = "2.2.8"
S = "${WORKDIR}/git"

EXTRA_OEMESON += " \
    -Dstatus-notifier=false \
    -Dpy-overrides-dir=${PYTHON_SITEPACKAGES_DIR}/gi \
"

FILES:${PN} += " \
    ${datadir}/mate-panel \
    ${datadir}/dbus-1 \
    ${libdir}/gtk-3.0/modules/libxapp-gtk3-module.so \
"
RDEPENDS:${PN} = " \
    bash \
    python3-core \
"

FILES:${PN}-dev += "${datadir}/glade"

PACKAGES += "${PN}-python3"
FILES:${PN}-python3 += "${PYTHON_SITEPACKAGES_DIR}"
RDEPENDS::${PN}-python3 = " \
    ${PN} \
"
