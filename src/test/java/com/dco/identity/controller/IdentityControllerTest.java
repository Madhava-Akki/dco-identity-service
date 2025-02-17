package com.dco.identity.controller;

@SpringBootTest
@AutoConfigureMockMvc
class IdentityControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Mock
    private IdentityService service;

    private IdentityDTO identityDTO;

    @BeforeEach
    void setUp() {
        identityDTO = new IdentityDTO("SSN1234", new byte[]{1, 2, 3}, new byte[]{4, 5, 6});
    }

    @Test
    void testCreateIdentitySuccess() throws Exception {
        when(service.createIdentity(any())).thenReturn(identityDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/identity")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(identityDTO)))
                .andExpect(status().isCreated());
    }
}
